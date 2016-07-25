/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のShujiiHoshumeisaiEditorです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiEditor implements IShujiiHoshumeisaiEditor {

    private final ShujiiHoshumeisaiEntity item;
    private static final LasdecCode LASDEC_CODE = new LasdecCode("000000");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiHoshumeisaiEntity}
     */
    protected ShujiiHoshumeisaiEditor(ShujiiHoshumeisaiEntity item) {
        this.item = item;
    }

    @Override
    public ShujiiHoshumeisaiReportSource edit(ShujiiHoshumeisaiReportSource source) {
        source.title = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬支払明細書, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.主治医意見書作成報酬支払明細書.get名称());
        RString printTimeStampSb = FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.taishoKikan = item.get対象期間();
        source.hokenshaName = item.get保険者名();
        source.iryokikanName = item.get医療機関名();
        source.ishiName = item.get医師名();
        source.printTimeStamp = printTimeStampSb;
        source.shujiiCode = item.get主治医コード();
        source.listIkenshosakuseiryo_1 = item.get明細番号();
        source.listIkenshosakuseiryo_2 = item.get被保険者番号();
        source.listIkenshosakuseiryo_3 = item.get被保険者氏名();
        source.listIkenshosakuseiryo_4 = item.get生年月日();
        source.listIkenshosakuseiryo_5 = item.get意見書提出日();
        source.listIkenshosakuseiryo_6 = item.get新規在宅();
        source.listIkenshosakuseiryo_7 = item.get新規施設();
        source.listIkenshosakuseiryo_8 = item.get継続在宅();
        source.listIkenshosakuseiryo_9 = item.get継続施設();
        source.listIkenshosakuseiryo_10 = kinngakuFormat(item.get意見書作成料());
        source.listGokeikensu_1 = kinngakuFormat(item.get新規在宅件数());
        source.listGokeikensu_2 = kinngakuFormat(item.get新規施設件数());
        source.listGokeikensu_3 = kinngakuFormat(item.get継続在宅件数());
        source.listGokeikensu_4 = kinngakuFormat(item.get継続施設件数());
        source.gokeiKingaku = kinngakuFormat(item.get合計金額());
        source.shouhiZei = kinngakuFormat(item.get消費税());
        source.gokeiSeikyuKingaku = kinngakuFormat(item.get合計請求額());
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        return edit2(source);
    }

    private ShujiiHoshumeisaiReportSource edit2(ShujiiHoshumeisaiReportSource source) {
        if (item.get被保険者番号() != null) {
            source.hihokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), item.get被保険者番号());
        }
        return source;
    }

    private RString kinngakuFormat(RString data) {
        if (data == null || data.isEmpty()) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(data.toString()), 0);
    }
}
