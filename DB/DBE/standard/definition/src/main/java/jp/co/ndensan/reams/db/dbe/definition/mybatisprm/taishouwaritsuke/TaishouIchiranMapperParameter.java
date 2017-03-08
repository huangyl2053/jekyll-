/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会対象者対象者一覧エリア内容検索パラメータクラス。
 *
 * @reamsid_L DBE-0140-010 liangbc
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaishouIchiranMapperParameter {

    private final RString kaisaiNo;
    private final boolean isButtonPushed;
    private final RString customOrder;
    private final RString tsujou;
    private final RString ennki;
    private final boolean isSort;
    private final boolean isShiryosakuseizumiKomi;
    private final boolean isDummyGogitai;

    /**
     * コンストラクタです。 「審査会順番を振りなおす」ボタンを押下しない場合
     *
     * @param kaisaiNo 開催番号
     */
    private TaishouIchiranMapperParameter(RString kaisaiNo, boolean isDummyGogitai) {
        this.kaisaiNo = kaisaiNo;
        this.isButtonPushed = false;
        this.customOrder = RString.EMPTY;
        this.tsujou = ShoriJotaiKubun.通常.getコード();
        this.ennki = ShoriJotaiKubun.延期.getコード();
        this.isSort = false;
        this.isShiryosakuseizumiKomi = false;
        this.isDummyGogitai = isDummyGogitai;
    }
    
    /**
     * コンストラクタです。 「審査会順番を振りなおす」ボタンを押下しない場合(ソート用)
     *
     * @param kaisaiNo 開催番号
     * @param isSort ソート検索有無
     * @param isShiryosakuseizumiKomi 審査会資料作成済みデータも含むかフラグ
     */
    private TaishouIchiranMapperParameter(RString kaisaiNo, boolean isSort, boolean isShiryosakuseizumiKomi, boolean isDummyGogitai) {
        this.kaisaiNo = kaisaiNo;
        this.isButtonPushed = false;
        this.customOrder = RString.EMPTY;
        this.tsujou = ShoriJotaiKubun.通常.getコード();
        this.ennki = ShoriJotaiKubun.延期.getコード();
        this.isSort = isSort;
        this.isShiryosakuseizumiKomi = isShiryosakuseizumiKomi;
        this.isDummyGogitai = isDummyGogitai;
    }

    /**
     * コンストラクタです。 「審査会順番を振りなおす」ボタンを押下した場合(ソート用)
     *
     * @param kaisaiNo 開催番号
     * @param customOrder カスタムコンフィグの審査会順序
     * @param isSort ソート検索有無
     * @param isShiryosakuseizumiKomi 審査会資料作成済みデータも含むかフラグ
     */
    private TaishouIchiranMapperParameter(RString kaisaiNo, RString customOrder, boolean isSort, boolean isShiryosakuseizumiKomi, boolean isDummyGogitai) {
        this.kaisaiNo = kaisaiNo;
        this.isButtonPushed = true;
        this.tsujou = ShoriJotaiKubun.通常.getコード();
        this.ennki = ShoriJotaiKubun.延期.getコード();
        this.customOrder = customOrder.replace("DbT5502ShinsakaiWariateJoho", "DbT5502").replace("DbT5101NinteiShinseiJoho", "DbT5101")
                .replace("DbT5116IchijiHanteiKekkaJoho", "DbT5116").replace("DbT7051KoseiShichosonMaster", "DbT7051").
                replace("DbT5203NinteichosahyoKihonChosa", "DbT5203").replace("DbT5304ShujiiIkenshoIkenItem", "DbT5304_13")
                .replace("DbT5105NinteiKanryoJoho", "DbT5105").replace("DbT5910NinteichosaItakusakiJoho", "DbT5910").
                replace("DbT5911ShujiiIryoKikanJoho", "DbT5911").replace("DbT5913ChosainJoho", "DbT5913")
                .replace("DbT5912ShujiiJoho", "DbT5912");
        this.isSort = isSort;
        this.isShiryosakuseizumiKomi = isShiryosakuseizumiKomi;
        this.isDummyGogitai = isDummyGogitai;
    }

    /**
     * キー検索用のパラメータを生成します。「審査会順番を振りなおす」ボタンを押下した場合(ソート用)
     *
     * @param kaisaiNo 開催番号
     * @param customOrder カスタムコンフィグの審査会順序
     * @param isSort ソート検索有無
     * @param isShiryosakuseizumiKomi 審査会資料作成済みデータも含むかフラグ
     * @return 介護認定審査会対象者対象者一覧エリア内容検索パラメータ
     */
    public static TaishouIchiranMapperParameter createTaishouIchiranMapperParameter(
            RString kaisaiNo, RString customOrder, boolean isSort, boolean isShiryosakuseizumiKomi, boolean isDummyGogitai) {
        return new TaishouIchiranMapperParameter(kaisaiNo, customOrder, isSort, isShiryosakuseizumiKomi, isDummyGogitai);
    }

    /**
     * キー検索用のパラメータを生成します。「審査会順番を振りなおす」ボタンを押下しない場合
     *
     * @param kaisaiNo 開催番号
     * @return 介護認定審査会対象者対象者一覧エリア内容検索パラメータ
     */
    /**
     * キー検索用のパラメータを生成します。「審査会順番を振りなおす」ボタンを押下しない場合(ソート用)
     * 
     * @param kaisaiNo 開催番号
     * @param isSort ソート検索有無
     * @param isShiryosakuseizumiKomi 審査会資料作成済みデータも含むかフラグ
     * @return 介護認定審査会対象者対象者一覧エリア内容検索パラメータ
     */
    public static TaishouIchiranMapperParameter createTaishouIchiranMapperParameter(
            RString kaisaiNo, boolean isSort, boolean isShiryosakuseizumiKomi, boolean isDummyGogitai) {
        return new TaishouIchiranMapperParameter(kaisaiNo, isSort, isShiryosakuseizumiKomi, isDummyGogitai);
    }

    /**
     * キー検索用のパラメータを生成します。「審査会順番を振りなおす」ボタンを押下しない場合
     *
     * @param kaisaiNo 開催番号
     * @return 介護認定審査会対象者対象者一覧エリア内容検索パラメータ
     */
    public static TaishouIchiranMapperParameter createTaishouIchiranMapperParameter(
            RString kaisaiNo, boolean isDummyGogitai) {
        return new TaishouIchiranMapperParameter(kaisaiNo, isDummyGogitai);
    }
}
