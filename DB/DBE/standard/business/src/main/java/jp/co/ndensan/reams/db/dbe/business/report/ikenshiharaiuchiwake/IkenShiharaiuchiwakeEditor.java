/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake.IkenShiharaiuchiwakeEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshiharaiuchiwake.IkenShiharaiuchiwakeReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のIkenShiharaiuchiwakeEditorです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
public class IkenShiharaiuchiwakeEditor implements IIkenShiharaiuchiwakeEditor {

    private final IkenShiharaiuchiwakeEntity item;
    private static final RString TITLE = new RString("主治医意見書作成料支払内訳確認書");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenShiharaiuchiwakeEntity}
     */
    public IkenShiharaiuchiwakeEditor(IkenShiharaiuchiwakeEntity item) {
        this.item = item;
    }

    @Override
    public IkenShiharaiuchiwakeReportSource edit(IkenShiharaiuchiwakeReportSource source) {
        source.layoutBreakItem = item.getLayoutBreakItem();
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
        source.kikanNameText = item.get医療機関();
        source.shimeiText = item.get代表者名();
        source.meishoFuyo = item.get名称付与();
        source.customerBarCode = item.getバーコード();
        source.sonota = item.getその他();
        source.pageCount = item.getページ番号2();
        source.title = TITLE;
        source.tsuchibun1 = item.get通知文1();
        source.gokeiKingaku = item.get合計金額();
        source.taishoKikan = item.get対象期間();
        source.shiharaiKensu = item.get件数();
        source.furikomiyoteiYMD = item.get振込予定日();
        source.kinyukikan = item.get金融機関();
        source.shitenName = item.get支店();
        source.meiginin = item.get口座名義人();
        source.shubetsu = item.get口座種別();
        source.bango = item.get口座番号();
        source.listShiharaiuchiwake_1 = item.get明細番号();
        source.listShiharaiuchiwake_2 = item.get被保険者番号();
        source.listShiharaiuchiwake_3 = item.get被保険者氏名();
        source.listShiharaiuchiwake_4 = item.get内訳住所();
        source.listShiharaiuchiwake_5 = item.get金額();
        source.tsuchibun2 = item.get通知文2();
        source.iryokikanCode = item.get医療機関コード();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        return edit2(source);
    }

    private IkenShiharaiuchiwakeReportSource edit2(IkenShiharaiuchiwakeReportSource source) {
        if (item.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), item.get被保険者番号());
        }
        return source;
    }
}
