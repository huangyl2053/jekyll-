/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd522002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.EnkiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522002.NinteiEnkiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定延期通知書発行一覧表ボディEditorです。
 *
 * @reamsid_L DBD-1410-040 chenxin
 */
class NinteiEnkiTsuchishoHakkoIchiranhyoBodyEditor implements INinteiEnkiTsuchishoHakkoIchiranhyoEditor {

    private final EnkiTsuchishoEntity entity;

    protected NinteiEnkiTsuchishoHakkoIchiranhyoBodyEditor(EnkiTsuchishoEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定延期通知書発行一覧表ボディEditorです。
     *
     * @param source NinteiEnkiTsuchishoHakkoIchiranhyoReportSource
     * @return source NinteiEnkiTsuchishoHakkoIchiranhyoReportSource
     */
    @Override
    public NinteiEnkiTsuchishoHakkoIchiranhyoReportSource edit(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        editNo(source);
        edit被保番号(source);
        edit氏名(source);
        edit住所(source);
        edit申請日(source);
        edit申請事由(source);
        edit一次判定日(source);
        edit一次判定(source);
        edit一次重(source);
        edit資料作成日(source);
        edit審査予定日(source);
        edit延期通知書発行回数(source);
        edit前回要介護度(source);
        edit前回認定開始日(source);
        edit前回認定終了日(source);
        return source;
    }

    private void editNo(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_1 = new RString(entity.get連番());
    }

    private void edit被保番号(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_2 = entity.get被保番号();
    }

    private void edit氏名(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        if (entity.get氏名() != null) {
            source.listHakkoIchiranhyo_3 = entity.get氏名().getColumnValue();
        }
    }

    private void edit住所(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        if (entity.get住所() != null) {
            source.listHakkoIchiranhyo_4 = entity.get住所().getColumnValue();
        }
    }

    private void edit申請日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_5 = entity.get申請日() == null ? RString.EMPTY : entity.get申請日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void edit申請事由(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_6 = entity.get申請理由();
    }

    private void edit一次判定日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_7 = entity.get一次判定年月日() == null ? RString.EMPTY : entity.get一次判定年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void edit一次判定(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        if (isコードNullOrEmpty(entity.get厚労省IF識別コード()) || isコードNullOrEmpty(entity.get一次判定結果コード())) {
            return;
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_8 = IchijiHanteiKekkaCode99.toValue(entity.get一次判定結果コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_8 = IchijiHanteiKekkaCode02.toValue(entity.get一次判定結果コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード()
                .equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_8 = IchijiHanteiKekkaCode06.toValue(entity.get一次判定結果コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_8 = IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果コード().value()).get名称();
        } else {
            source.listHakkoIchiranhyo_8 = null;
        }
    }

    private boolean isコードNullOrEmpty(Code コード) {
        return null == コード || コード.isEmpty();
    }

    private void edit一次重(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        if (isコードNullOrEmpty(entity.get厚労省IF識別コード()) || isコードNullOrEmpty(entity.get一五次判定結果コード())) {
            return;
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_9 = IchijiHanteiKekkaCode99.toValue(entity.get一五次判定結果コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_9 = IchijiHanteiKekkaCode02.toValue(entity.get一五次判定結果コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_9 = IchijiHanteiKekkaCode06.toValue(entity.get一五次判定結果コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_9 = IchijiHanteiKekkaCode09.toValue(entity.get一五次判定結果コード().value()).get名称();
        } else {
            source.listHakkoIchiranhyo_9 = null;
        }
    }

    private void edit資料作成日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_10 = null == entity.get資料作成日() ? RString.EMPTY : entity.get資料作成日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void edit審査予定日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_11 = null == entity.get審査会予定日() ? RString.EMPTY : entity.get審査会予定日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void edit延期通知書発行回数(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_12 = new RString(entity.get延期通知発行回数());
    }

    private void edit前回要介護度(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        if (isコードNullOrEmpty(entity.get厚労省IF識別コード()) || isコードNullOrEmpty(entity.get前回要介護状態区分コード())) {
            return;
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_13 = YokaigoJotaiKubun99.toValue(entity.get前回要介護状態区分コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_13 = YokaigoJotaiKubun02.toValue(entity.get前回要介護状態区分コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード()
                .equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_13 = YokaigoJotaiKubun06.toValue(entity.get前回要介護状態区分コード().value()).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード().value())) {
            source.listHakkoIchiranhyo_13 = YokaigoJotaiKubun09.toValue(entity.get前回要介護状態区分コード().value()).get名称();
        } else {
            source.listHakkoIchiranhyo_13 = null;
        }
    }

    private void edit前回認定開始日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_14 = null == entity.get前回認定開始日() ? RString.EMPTY : entity.get前回認定開始日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void edit前回認定終了日(NinteiEnkiTsuchishoHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_15 = null == entity.get前回認定終了日() ? RString.EMPTY : entity.get前回認定終了日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
