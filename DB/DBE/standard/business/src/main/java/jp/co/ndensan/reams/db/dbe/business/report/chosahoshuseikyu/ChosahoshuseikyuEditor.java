/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuseikyu;

import jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu.Chosahoshuseikyu;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuseikyu.ChosahoshuseikyuReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬請求書のEditorです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
public class ChosahoshuseikyuEditor implements IChosahoshuseikyuEditor {

    private final Chosahoshuseikyu item;
    private static final LasdecCode LASDEC_CODE = new LasdecCode("000000");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link Chosahoshuseikyu}
     */
    protected ChosahoshuseikyuEditor(Chosahoshuseikyu item) {
        this.item = item;
    }

    @Override
    public ChosahoshuseikyuReportSource edit(ChosahoshuseikyuReportSource source) {
        return editSource(source);
    }

    private ChosahoshuseikyuReportSource editSource(ChosahoshuseikyuReportSource source) {
        source.hakkoYMD = item.get発行年月日();
        source.chosaItakusakiYubimNo = item.get郵便番号();
        source.chosaItakusakiJusho = item.get住所();
        source.chosaItakusakiName = item.get調査機関();
        source.daihyoshaName = item.get代表者名();
        source.title = DbBusinessConfig.get(ConfigNameDBE.認定調査報酬支払通知書, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.認定調査報酬支払通知書.get名称());
        source.tsuchibun1 = item.get通知文1();
        source.taishoKikan = item.get対象期間();
        source.gokeiKingaku1 = nullOrZero(item.get合計金額());
        source.sakuseiKensuKei = nullOrZero(item.get作成件数合計());
        source.shokeiKingaku = nullOrZero(item.get小計());
        source.shohizei = nullOrZero(item.get消費税額());
        source.gokeiKingaku2 = nullOrZero(item.get請求金額());
        source.tsuchibun2 = item.get通知文2();
        source.ninteichosaItakusakiCode = item.get認定調査委託先コード();
        return source;
    }

    private RString nullOrZero(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return new RString("0");
        }
        return date;
    }
}
