/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.kaigojuminhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタのデータアクセスクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChushutsuKikanJohoEntity {

    private RString taishoKaishiYMD;
    private RString taishoShuryoYMD;
    private RString taishoKaishiTimestamp;
    private RString taishoShuryoTimestamp;

    /**
     * コンストラクタです。
     *
     * @param taishoKaishiYMD 対象開始年月日
     * @param taishoShuryoYMD 対象終了年月日
     * @param taishoKaishiTimestamp 対象開始日時
     * @param taishoShuryoTimestamp 対象終了日時
     */
    public ChushutsuKikanJohoEntity(RString taishoKaishiYMD, RString taishoShuryoYMD, RString taishoKaishiTimestamp, RString taishoShuryoTimestamp) {
        this.taishoKaishiYMD = taishoKaishiYMD;
        this.taishoShuryoYMD = taishoShuryoYMD;
        this.taishoKaishiTimestamp = taishoKaishiTimestamp;
        this.taishoShuryoTimestamp = taishoShuryoTimestamp;
    }
}
