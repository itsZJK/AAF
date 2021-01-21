# commit 风格
  使用中文表达,尽量控制在 20 个字以内
  (如果你发觉 20 个字描述不了，那很可能是因为这一次 commit 不够纯粹，可以考虑将之分成两部分内容或更多内容分次提交)

  保持 commit 是纯粹的、详细的
  (有利于我们发现问题时进行细粒化到具体内容 revert commit，而不是遇到问题需要 revert 结果把一些好的、没问题的内容也捆绑 revert 掉了)

  格式:(一般情况下使用下面 7 种标识已经足够了)
  feat：新功能（feature）
  fix：修补bug
  docs：文档（documentation）
  style： 格式（不影响代码运行的变动）
  refactor：重构（即不是新增功能，也不是修改bug的代码变动）
  test：增加测试
  chore：构建过程或辅助工具的变动






