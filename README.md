# 🚀 Jenkins Multibranch CI/CD with ArgoCD for Kubernetes Environments

**Project Type:** DevOps | GitOps | CI/CD Automation  
**Author:** Yossef Azozz  
**Purpose:** Demonstrate a fully automated **multi-environment CI/CD pipeline** using **Jenkins Multibranch Pipeline + ArgoCD** for Kubernetes deployments.

---

## 📖 Introduction

This project implements a **Jenkins Multibranch CI/CD pipeline** integrated with **ArgoCD** to automate **Kubernetes deployments** across **Development, Staging, and Production** environments.

The pipeline dynamically selects the **correct Kubernetes manifests** based on **branch or tag conventions**, ensuring a seamless **GitOps-driven deployment** workflow.

---

## ✨ Key Features

- **Multibranch Jenkins Pipeline**
  - Automatically triggers for new branches and PRs.
  - Uses **branch names or Git tags** to determine the target environment.

- **Dynamic Environment Deployment**
  - `dev` → Deploys to Development namespace.
  - `stage` → Deploys to Staging namespace.
  - `prod` → Deploys to Production namespace.

- **ArgoCD Integration**
  - Jenkins updates the **GitOps repository** with the latest manifests.
  - ArgoCD automatically syncs changes to the correct environment.

- **Shared Jenkins Library**
  - Common pipeline logic stored in `vars/`.
  - Supports dynamic **namespace and manifest selection**.

---

## 🏗️ CI/CD Workflow

1. **Developer pushes code** to any branch or opens a PR.
2. **Jenkins Multibranch Pipeline** runs automatically:
   - Builds and tests the application.
   - Builds and pushes Docker images to the registry.
3. **Manifest Update Stage**:
   - Updates Kubernetes manifests with the new image & environment.
   - Pushes updated manifests to the **GitOps repo**.
4. **ArgoCD Sync**:
   - ArgoCD detects the GitOps change.
   - Deploys to the corresponding **Kubernetes namespace**.

---

## 📂 Repository Structure
shared_lib_jenkins/
├── argocd-lab/ # Kubernetes manifests & ArgoCD application configurations
│ ├── dev/ # Dev environment manifests
│ ├── stag/ # Stag environment manifests
│ └── prod/ # Prod environment manifests
│
├── vars/ # Jenkins Shared Library scripts
│ ├── deploy.groovy # Handles environment-based deployment logic
│ └── utils.groovy # (Optional) Helper functions for pipelines
│
├── Jenkinsfile # (Optional) Example pipeline using shared library
└── README.md # Project documentation

