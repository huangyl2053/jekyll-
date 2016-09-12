/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai.ChosaHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshushiharai.ChosaHoshuShiharaiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBE621003_認定調査報酬支払通知書のChosaHoshuShiharaiEditorです。
 *
 * @reamsid_L DBE-1980-041 xuyongchao
 */
public class ChosaHoshuShiharaiEditor implements IChosaHoshuShiharaiEditor {

    private final ChosaHoshuShiharaiEntity item;
    private static final LasdecCode LASDEC_CODE = new LasdecCode("000000");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaHoshuShiharaiEntity}
     */
    protected ChosaHoshuShiharaiEditor(ChosaHoshuShiharaiEntity item) {
        this.item = item;
    }

    @Override
    public ChosaHoshuShiharaiReportSource edit(ChosaHoshuShiharaiReportSource source) {
        source.denshiKoin = item.get電子公印();
        source.hakkoYMD1 = item.get発行日();
        source.ninshoshaYakushokuMei = item.get認証者役職名();
        source.ninshoshaYakushokuMei1 = item.get認証者役職名1();
        source.koinMojiretsu = item.get公印文字列();
        source.ninshoshaYakushokuMei2 = item.get認証者役職名2();
        source.ninshoshaShimeiKakenai = item.get認証者氏名カナ();
        source.ninshoshaShimeiKakeru = item.get認証者氏名掛ける();
        source.koinShoryaku = item.get公印省略();
        source.yubinNo = item.get郵便番号();
        source.jushoText = item.get住所();
        source.kikanNameText = item.get調査機関();
        source.shimeiText = item.get代表者名();
        source.meishoFuyo = item.get名称付与();
        source.customerBarCode = item.getバーコード();
        source.sonota = item.getその他();
        source.pageCount = item.getページ番号2();
        source.title = DbBusinessConfig.get(ConfigNameDBE.認定調査報酬支払通知書, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.認定調査報酬支払通知書.get名称());
        source.tsuchibun1 = item.get通知文1();
        source.taishoKikan = item.get対象期間();
        source.gokei = nullOrZero(item.get合計金額());
        source.furikomiyoteiYMD = item.get振込予定日();
        source.shubetsu = item.get種別();
        source.bango = item.get番号();
        source.kinyukikan = item.get金融機関();
        source.meiginin = item.get名議人();
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
