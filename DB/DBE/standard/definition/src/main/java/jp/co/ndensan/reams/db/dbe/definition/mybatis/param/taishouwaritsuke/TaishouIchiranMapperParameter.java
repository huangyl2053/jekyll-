/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会対象者対象者一覧エリア内容検索パラメータクラス。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaishouIchiranMapperParameter {

    private final RString kaisaiNo;
    private final boolean isButtonPushed;
    private final RString customOrder;

    /**
     * コンストラクタです。 「審査会順番を振りなおす」ボタンを押下しない場合
     *
     * @param kaisaiNo 開催番号
     */
    private TaishouIchiranMapperParameter(RString kaisaiNo) {
        this.kaisaiNo = kaisaiNo;
        this.isButtonPushed = false;
        this.customOrder = RString.EMPTY;
    }

    /**
     * コンストラクタです。 「審査会順番を振りなおす」ボタンを押下した場合
     *
     * @param kaisaiNo 開催番号
     * @param customOrder カスタムコンフィグの審査会順序
     */
    private TaishouIchiranMapperParameter(RString kaisaiNo, RString customOrder) {
        this.kaisaiNo = kaisaiNo;
        this.isButtonPushed = true;
        this.customOrder = customOrder.replace("DbT5502ShinsakaiWariateJoho", "DbT5502").replace("DbT5101NinteiShinseiJoho", "DbT5101")
                .replace("DbT5116IchijiHanteiKekkaJoho", "DbT5116").replace("DbT7051KoseiShichosonMaster", "DbT7051").
                replace("DbT5203NinteichosahyoKihonChosa", "DbT5203").replace("DbT5304ShujiiIkenshoIkenItem", "DbT5304_13")
                .replace("DbT5105NinteiKanryoJoho", "DbT5105").replace("DbT5910NinteichosaItakusakiJoho", "DbT5910").
                replace("DbT5911ShujiiIryoKikanJoho", "DbT5911").replace("DbT5913ChosainJoho", "DbT5913")
                .replace("DbT5912ShujiiJoho", "DbT5912");
    }

    /**
     * キー検索用のパラメータを生成します。「審査会順番を振りなおす」ボタンを押下した場合
     *
     * @param kaisaiNo 開催番号
     * @param customOrder カスタムコンフィグの審査会順序
     * @return 介護認定審査会対象者対象者一覧エリア内容検索パラメータ
     */
    public static TaishouIchiranMapperParameter createTaishouIchiranMapperParameter(RString kaisaiNo, RString customOrder) {
        return new TaishouIchiranMapperParameter(kaisaiNo, customOrder);
    }

    /**
     * キー検索用のパラメータを生成します。「審査会順番を振りなおす」ボタンを押下しない場合
     *
     * @param kaisaiNo 開催番号
     * @return 介護認定審査会対象者対象者一覧エリア内容検索パラメータ
     */
    public static TaishouIchiranMapperParameter createTaishouIchiranMapperParameter(RString kaisaiNo) {
        return new TaishouIchiranMapperParameter(kaisaiNo);
    }
}
