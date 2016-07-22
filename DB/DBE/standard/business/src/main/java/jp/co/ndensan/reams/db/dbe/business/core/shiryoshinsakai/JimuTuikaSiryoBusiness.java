/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTuikaSiryoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.IinTuikaSiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護認定追加資料鑑情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuTuikaSiryoBusiness {

    private static final RString 警告_有 = new RString("有");
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_1 = 7;
    private static final int INDEX_0 = 0;
    private final IinTuikaSiryoEntity entity;
    private final IinTuikaSiryoEntity siryoEntity;
    private final List<ShinsakaiIinJohoEntity> 審査員;
    private final IinTuikaSiryoProcessParameter paramter;
    private final int 審査対象者数;
    private final RString 通知文1;

    /**
     * コンストラクタです。
     *
     * @param entity IinTuikaSiryoEntity
     * @param 審査員 List<ShinsakaiIinJohoEntity>
     * @param paramter IinTuikaSiryoProcessParameter
     * @param 審査対象者数 int
     * @param siryoEntity IinTuikaSiryoEntity
     * @param 通知文1 通知文1
     */
    public JimuTuikaSiryoBusiness(
            IinTuikaSiryoEntity entity,
            List<ShinsakaiIinJohoEntity> 審査員,
            IinTuikaSiryoProcessParameter paramter,
            int 審査対象者数,
            IinTuikaSiryoEntity siryoEntity,
            RString 通知文1) {
        this.entity = entity;
        this.審査員 = 審査員;
        this.paramter = paramter;
        this.審査対象者数 = 審査対象者数;
        this.siryoEntity = siryoEntity;
        this.通知文1 = 通知文1;
    }

    /**
     * 審査会審査順を取得します。
     *
     * @return 審査会審査順
     */
    public RString get審査会審査順() {
        return new RString(entity.getShinsakaiOrder());
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        if (entity.getHihokenshaName() != null && !entity.getHihokenshaName().isEmpty()) {
            return entity.getHihokenshaName().value();
        }
        return RString.EMPTY;
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        if (entity.getSeibetsu() == null || entity.getSeibetsu().isEmpty()) {
            return RString.EMPTY;
        }
        return Seibetsu.toValue(entity.getSeibetsu().value()).get名称();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return new RString(entity.getAge());
    }

    /**
     * 申請日を取得します。
     *
     * @return 申請日
     */
    public RString get申請日() {
        if (entity.getNinteiShinseiYMD() == null || entity.getNinteiShinseiYMD().isEmpty()) {
            return RString.EMPTY;
        }
        return entity.getNinteiShinseiYMD().wareki().toDateString();
    }

    /**
     * 申請区分を取得します。
     *
     * @return 申請区分
     */
    public RString get申請区分() {
        if (entity.getShinseijiKubunCode() == null || entity.getShinseijiKubunCode().isEmpty()) {
            return RString.EMPTY;
        }
        return NinteiShinseiShinseijiKubunCode.toValue(entity.getShinseijiKubunCode().value()).get名称();
    }

    /**
     * 前回一次を取得します。
     *
     * @return 前回一次
     */
    public RString get前回一次() {
        if (entity.getZenIchijiHanteiKekkaCode() == null || entity.getZenIchijiHanteiKekkaCode().isEmpty()) {
            return RString.EMPTY;
        }
        return IchijiHanteiKekkaCode09.toValue(entity.getZenIchijiHanteiKekkaCode().value()).get名称();
    }

    /**
     * 前回二次を取得します。
     *
     * @return 前回二次
     */
    public RString get前回二次() {
        if (entity.getJotaiKubunCode() == null || entity.getJotaiKubunCode().isEmpty()) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubun09.toValue(entity.getJotaiKubunCode().value()).get略称();
    }

    /**
     * 前回期間を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間() {
        return new RString(entity.getYukoKikan());
    }

    /**
     * 寝たきり度を取得します。
     *
     * @return 寝たきり度
     */
    public RString get寝たきり度() {
        if (entity.getNinchishoCode() == null || entity.getNinchishoCode().isEmpty()) {
            return RString.EMPTY;
        }
        return ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.getNinchishoCode().value()).get名称();
    }

    /**
     * 認知度を取得します。
     *
     * @return 認知度
     */
    public RString get認知度() {
        if (entity.getNinchishoCode() == null || entity.getNinchishoCode().isEmpty()) {
            return RString.EMPTY;
        }
        return NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.getNinchishoCode().value()).get名称();
    }

    /**
     * 基準時間を取得します。
     *
     * @return 基準時間
     */
    public RString get基準時間() {
        return new RString(entity.getKijunJikan());
    }

    /**
     * 一次判定を取得します。
     *
     * @return 一次判定
     */
    public RString get一次判定() {
        if (entity.getIchijiHanteiKekkaCode() == null || entity.getIchijiHanteiKekkaCode().isEmpty()) {
            return RString.EMPTY;
        }
        return IchijiHanteiKekkaCode09.toValue(entity.getIchijiHanteiKekkaCode().value()).get名称();
    }

    /**
     * 警告を取得します。
     *
     * @return 警告
     */
    public RString get警告() {
        return 警告有無(entity.getIchijiHnateiKeikokuCode());
    }

    /**
     * 審査結果を取得します。
     *
     * @return 審査結果
     */
    public RString get審査結果() {
        return RString.EMPTY;
    }

    /**
     * 期間を取得します。
     *
     * @return 期間
     */
    public RString get期間() {
        return RString.EMPTY;
    }

    /**
     * 審査員1を取得します。
     *
     * @return 審査員1
     */
    public RString get審査員1() {
        if (INDEX_0 < 審査員.size() && 審査員.get(INDEX_0) != null && 審査員.get(INDEX_0).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_0).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_0).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員2を取得します。
     *
     * @return 審査員2
     */
    public RString get審査員2() {
        if (INDEX_1 < 審査員.size() && 審査員.get(INDEX_1) != null && 審査員.get(INDEX_1).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_1).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_1).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員3を取得します。
     *
     * @return 審査員3
     */
    public RString get審査員3() {
        if (INDEX_2 < 審査員.size() && 審査員.get(INDEX_2) != null && 審査員.get(INDEX_2).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_2).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_2).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員4を取得します。
     *
     * @return 審査員4
     */
    public RString get審査員4() {
        if (INDEX_3 < 審査員.size() && 審査員.get(INDEX_3) != null && 審査員.get(INDEX_3).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_3).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_3).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員5を取得します。
     *
     * @return 審査員5
     */
    public RString get審査員5() {
        if (INDEX_4 < 審査員.size() && 審査員.get(INDEX_4) != null && 審査員.get(INDEX_4).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_4).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_4).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員6を取得します。
     *
     * @return 審査員6
     */
    public RString get審査員6() {
        if (INDEX_5 < 審査員.size() && 審査員.get(INDEX_5) != null && 審査員.get(INDEX_5).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_5).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_5).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員7を取得します。
     *
     * @return 審査員7
     */
    public RString get審査員7() {
        if (INDEX_6 < 審査員.size() && 審査員.get(INDEX_6) != null && 審査員.get(INDEX_6).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_6).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_6).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員8を取得します。
     *
     * @return 審査員8
     */
    public RString get審査員8() {
        if (INDEX_7 < 審査員.size() && 審査員.get(INDEX_7) != null && 審査員.get(INDEX_7).getShinsakaiIinShimei() != null
                && !RString.isNullOrEmpty(審査員.get(INDEX_7).getShinsakaiIinShimei().value())) {
            return 審査員.get(INDEX_7).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査会開催番号を取得します。
     *
     * @return 審査会開催番号
     */
    public RString get審査会開催番号() {
        return paramter.getShinsakaiKaisaiNo();
    }

    /**
     * 追加審査対象者数を取得します。
     *
     * @return 追加審査対象者数
     */
    public RString get追加審査対象者数() {
        return new RString(審査対象者数);
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return new RString(siryoEntity.getGogitaiNo());
    }

    /**
     * 審査会開催年月日を取得します。
     *
     * @return 審査会開催年月日
     */
    public RString get審査会開催年月日() {
        return get審査会開催年月日(fromatパターン9(siryoEntity.getShinsakaiKaisaiYMD()),
                日時転換(siryoEntity.getShinsakaiKaishiTime()));
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        if (RString.isNullOrEmpty(entity.getShichosonMeisho())) {
            return RString.EMPTY;
        }
        return entity.getShichosonMeisho();
    }

    /**
     * 通知文1を取得します。
     *
     * @return 通知文1
     */
    public RString get通知文1() {
        return 通知文1;
    }

    /**
     * 通知文2を取得します。
     *
     * @return 通知文2
     */
    public RString get通知文2() {
        return RString.EMPTY;
    }

    /**
     * 通知文3を取得します。
     *
     * @return 通知文3
     */
    public RString get通知文3() {
        return RString.EMPTY;
    }

    /**
     * 通知文4を取得します。
     *
     * @return 通知文4
     */
    public RString get通知文4() {
        return RString.EMPTY;
    }

    /**
     * 通知文5を取得します。
     *
     * @return 通知文5
     */
    public RString get通知文5() {
        return RString.EMPTY;
    }

    private RString 警告有無(RString 警告コード) {
        if (!RString.isNullOrEmpty(警告コード) && 警告コード.contains(new RString("1"))) {
            return 警告_有;
        }
        return RString.EMPTY;
    }

    private RString fromatパターン9(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString 日時転換(RString 日時) {
        if (!RString.isNullOrEmpty(日時)) {
            日時 = 日時.padZeroToLeft(INDEX_4);
            return RTime.of(Integer.parseInt(日時.substring(INDEX_0, INDEX_2).toString()),
                    Integer.parseInt(日時.substring(INDEX_2).toString())).toFormattedTimeString(DisplayTimeFormat.HH時mm分);
        }
        return RString.EMPTY;
    }

    private RString get審査会開催年月日(RString 開催年月日, RString 日時) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(開催年月日)
                .append(" ")
                .append(日時)
                .toRString();
    }
}
