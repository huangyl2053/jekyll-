/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshuseikyu;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshuseikyu.IkenshoHoshuSeikyuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshohoshuseikyu.IkenshoHoshuSeikyuReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBE621004_主治医意見書作成報酬請求書のIkenshoHoshuSeikyuEditorです。
 *
 * @reamsid_L DBE-1980-042 xuyongchao
 */
public class IkenshoHoshuSeikyuEditor implements IIkenshoHoshuSeikyuEditor {

    private final IkenshoHoshuSeikyuEntity item;
    private static final LasdecCode LASDEC_CODE = new LasdecCode("000000");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoHoshuSeikyuEntity}
     */
    protected IkenshoHoshuSeikyuEditor(IkenshoHoshuSeikyuEntity item) {
        this.item = item;
    }

    @Override
    public IkenshoHoshuSeikyuReportSource edit(IkenshoHoshuSeikyuReportSource source) {
        source.hakkoYMD = item.get発行年月日();
        source.iryokikanYubimNo = (item.get郵便番号() == null ? RString.EMPTY : new RString(item.get郵便番号().toString()));
        source.iryokikanJusho = item.get住所();
        source.iryokikanName = item.get医療機関();
        source.daihyoshaName = item.get代表者名();
        source.title = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬請求書, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.主治医意見書作成報酬請求書.get名称());
        source.tsuchibun1 = item.get通知文1();
        source.taishoKikan = item.get対象期間();
        source.gokeiKingaku2 = kinngakuFormat(item.get請求金額());
        source.sakuseiKensuKei = kinngakuFormat(item.get作成件数合計());
        source.shokeiKingaku = kinngakuFormat(item.get小計());
        source.shohizei = (item.get消費税額());
        source.gokeiKingaku1 = kinngakuFormat(item.get合計金額());
        source.tsuchibun2 = item.get通知文2();
        source.shujiiIryokikanCode = item.get主治医医療機関コード();
        return source;
    }

    private RString kinngakuFormat(RString data) {
        if (data == null || data.isEmpty()) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(data.toString()), 0);
    }
}
