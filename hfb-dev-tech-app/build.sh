# 普通镜像构建，随系统版本构建 amd/arm
docker build -t hanfeibo/ai-rag-knowledge-app:1.0 -f ./Dockerfile .

# 兼容 amd、arm 构建镜像
#docker buildx build --load --platform liunx/amd64,linux/arm64 -t hanfeibo/ai-rag-knowledge-app:1.0 -f ./Dockerfile . --push
# 修正后命令（多平台构建 + 直接推送）
#docker buildx build --platform linux/amd64,linux/arm64 -t hanfeibo/ai-rag-knowledge-app:1.0 -f ./Dockerfile . --push