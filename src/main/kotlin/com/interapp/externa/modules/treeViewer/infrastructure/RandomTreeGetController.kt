package com.interapp.externa.modules.treeViewer.infrastructure

import com.interapp.externa.core.tree.application.TreeSearch
import com.interapp.externa.core.tree.domain.Tree
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/treeViewer")
class RandomTreeGetController(private val treeSearch: TreeSearch) {
    @GetMapping("/trees/random")
    fun getRandomTree(): Tree {
        val trees = treeSearch.findTrees()
        val randomIndex = (0 until trees.size).random()
        return trees[randomIndex]
    }
}
