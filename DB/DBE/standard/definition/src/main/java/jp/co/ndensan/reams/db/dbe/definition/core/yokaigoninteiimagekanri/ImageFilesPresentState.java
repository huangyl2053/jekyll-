/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri;

/**
 * イメージの存在状況を表します。
 */
public enum ImageFilesPresentState {

    /**
     * イメージが存在しないことを表します。
     */
    存在しない,
    /**
     * イメージは存在するが、マスキングされたイメージは存在しないことを表します。
     */
    マスキング無,
    /**
     * イメージが存在し、且つ、マスキング済みの物も存在することを表します。
     */
    マスキング有;

    /**
     * @return 存在する場合、{@code ture}.
     */
    public boolean exists() {
        return this != 存在しない;
    }

    /**
     * @return マスク済みイメージが存在する場合、{@code true}.
     */
    public boolean hasMasked() {
        return this == マスキング有;
    }

}
