/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages;

/**
 * 処理の首里を表します。
 */
public enum Operation {

    /**
     * 照会
     */
    照会,
    /**
     * 修正
     */
    修正;

    /**
     * @return 修正の場合、{@code true}.
     */
    public boolean is修正() {
        return this == 修正;
    }
}
