/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 被保険者証発行管理一覧表ヘッダEditorクラスです。
 *
 * @reamsid_L DBA-0600-070 lishengli
 */
public class HihokenshashoHakkoKanriIchiranhyoEditor implements IHihokenshashoHakkoKanriIchiranhyoEditor {

    private final HihohenshashoHakkoKanriboChohyoDataSakuseiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link HihohenshashoHakkoKanriboChohyoDataSakuseiEntity}
     */
    protected HihokenshashoHakkoKanriIchiranhyoEditor(HihohenshashoHakkoKanriboChohyoDataSakuseiEntity entity) {
        this.entity = entity;
    }

    /**
     *
     * @param source 被保険者証発行管理一覧表のReportSourceクラス
     * @return HihokenshashoHakkoKanriIchiranhyoReportSource
     */
    @Override
    public HihokenshashoHakkoKanriIchiranhyoReportSource edit(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private HihokenshashoHakkoKanriIchiranhyoReportSource editHeader(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
        source.printTimeStamp = entity.get印刷日時();
        source.title = entity.get帳票タイトル();
        source.shichosonCode = entity.get市町村コード();
        source.shichosonName = entity.get市町村名();
        source.kaipage1 = entity.get改頁１();
        source.kaipage2 = entity.get改頁２();
        source.kaipage3 = entity.get改頁３();
        source.kaipage4 = entity.get改頁４();
        source.kaipage5 = entity.get改頁５();
        source.shutsuryokujun1 = entity.getソート順１();
        source.shutsuryokujun2 = entity.getソート順２();
        source.shutsuryokujun3 = entity.getソート順３();
        source.shutsuryokujun4 = entity.getソート順４();
        source.shutsuryokujun5 = entity.getソート順５();
        source.yubinNo = entity.get郵便番号();

        source.listUpper_1 = entity.get被保険者番号();
        source.listUpper_2 = entity.get識別コード();
        source.listUpper_3 = entity.get氏名();
        source.listUpper_4 = entity.get交付年月日Str();
        source.listUpper_5 = entity.get交付事由コード();
        source.listUpper_6 = entity.get交付事由名称();
        source.listUpper_7 = entity.get有効期限Str();
        source.listLower_1 = entity.get市町村コードListYou();
        source.listLower_2 = entity.get郵便番号();
        source.listLower_3 = entity.get住所();
        source.listLower_4 = entity.get回収年月日Str();
        source.listLower_5 = entity.get回収事由コード();
        source.listLower_6 = entity.get回収事由名称();
        source.listLower_7 = entity.get様式();

        if (!RString.isNullOrEmpty(entity.get識別コード()) && RStringUtil.isHalfsizeNumberOnly(entity.get識別コード())) {
            source.shikibetuCode = new ShikibetsuCode(entity.get識別コード());
        } else {
            source.shikibetuCode = ShikibetsuCode.EMPTY;
        }
        if (!RString.isNullOrEmpty(entity.get被保険者番号())) {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), entity.get被保険者番号());
        }

        source.hiddenPageBreaker = entity.get隠し改頁項目();

        return source;
    }
}
