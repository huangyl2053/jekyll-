/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaNinchishoKasanCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
    private static final int INDEX_4 = 4;
    private static final int INDEX_0 = 0;
    private final ShinseiJohoEntity entity;
    private final List<ShinsakaiIinJohoEntity> 審査員;
    private final IinShinsakaiIinJohoProcessParameter paramter;
    private final int 審査対象者数;
    private final RString 通知文1;
    private static final RString 前回二次_固定文字 = new RString("要介護状態区分コード");
    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");

    /**
     * コンストラクタです。
     *
     * @param entity IinTuikaSiryoEntity
     * @param 審査員 List<ShinsakaiIinJohoEntity>
     * @param paramter IinShinsakaiIinJohoProcessParameter
     * @param 審査対象者数 int
     * @param 通知文1 通知文1
     */
    public JimuTuikaSiryoBusiness(
            ShinseiJohoEntity entity,
            List<ShinsakaiIinJohoEntity> 審査員,
            IinShinsakaiIinJohoProcessParameter paramter,
            int 審査対象者数,
            RString 通知文1) {
        this.entity = entity;
        this.審査員 = 審査員;
        this.paramter = paramter;
        this.審査対象者数 = 審査対象者数;
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
     * 前回二次を取得します。
     *
     * @return 前回二次
     */
    public RString get前回二次() {
        return get要介護状態区分(entity.getNijiHanteiCode());
    }

    /**
     * 前回期間を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間() {
        return get前回期間(entity.getNijiHanteiKikan());
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
        return get要介護認定一次判定結果(entity.getIchijiHanteiKekkaCode(), entity.getIchijiHanteiKasanCode());
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
     * 前回期間_上を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間_上() {
        return RString.EMPTY;
    }

    /**
     * 前回期間_下を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間_下() {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(パターン13(entity.getNijiHanteiKaishiYMD()))
                .append("～")
                .append(パターン13(entity.getNijiHanteiShuryoYMD())).toRString();
    }

    /**
     * 審査員一覧を取得します。
     *
     * @return 審査員一覧
     */
    public List<ShinsakaiIinJohoEntity> get審査員一覧() {
        return 審査員;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo().getColumnValue();
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
        return paramter.getGogitaiNo();
    }

    /**
     * 審査会開催年月日を取得します。
     *
     * @return 審査会開催年月日
     */
    public RString get審査会開催年月日() {
        return get審査会開催年月日(fromatパターン9(paramter.getShinsakaiKaisaiYoteiYMD()),
                日時転換(paramter.getShinsakaiKaishiYoteiTime()));
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        if (RString.isNullOrEmpty(entity.getShoKisaiHokenshaNo())) {
            return RString.EMPTY;
        }
        return entity.getShoKisaiHokenshaNo();
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

    private RString get前回期間(int 期間) {
        RStringBuilder 前回期間 = new RStringBuilder();
        前回期間.append(期間);
        前回期間.append(new RString("ヵ月"));
        return 前回期間.toRString();
    }

    private RString get要介護状態区分(Code 状態区分コード) {
        RStringBuilder builder = new RStringBuilder();
        if (状態区分コード != null && !状態区分コード.isEmpty()) {
            RString 厚労省IF識別コード = entity.getKoroshoCode().getColumnValue();
            if (A_99.equals(厚労省IF識別コード)) {
                return builder.append(前回二次_固定文字).append(YokaigoJotaiKubun99.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            } else if (A_02.equals(厚労省IF識別コード)) {
                return builder.append(前回二次_固定文字).append(YokaigoJotaiKubun02.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            } else if (A_06.equals(厚労省IF識別コード)) {
                return builder.append(前回二次_固定文字).append(YokaigoJotaiKubun06.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
                return builder.append(前回二次_固定文字).append(YokaigoJotaiKubun09.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            }
        }
        return RString.EMPTY;
    }

    private RString get要介護認定一次判定結果(Code 判定結果コード, Code 判定結果コード_認知症加算) {
        RStringBuilder builder = new RStringBuilder();
        if (判定結果コード != null && !判定結果コード.isEmpty()
                && 判定結果コード_認知症加算 != null && !判定結果コード_認知症加算.isEmpty()) {
            RString 判定結果コード名称 = IchijiHanteiKekkaCode09.toValue(判定結果コード.getColumnValue()).get名称();
            RString 判定結果コード_認知症加算名称 = IchijiHanteiKekkaNinchishoKasanCode.toValue(判定結果コード_認知症加算.getColumnValue()).get名称();
            if (判定結果コード.equals(判定結果コード_認知症加算)) {
                return 判定結果コード名称;
            } else {
                return builder.append(判定結果コード名称)
                        .append("→")
                        .append(判定結果コード_認知症加算名称).toRString();
            }
        }
        return RString.EMPTY;
    }

    private RString get開催年月日() {
        RStringBuilder 審査会開催年月日 = new RStringBuilder();
        審査会開催年月日.append(パターン33(paramter.getShinsakaiKaisaiYoteiYMD()));
        審査会開催年月日.append(paramter.getShinsakaiKaishiYoteiTime().substring(0, 2));
        審査会開催年月日.append(new RString("時"));
        審査会開催年月日.append(paramter.getShinsakaiKaishiYoteiTime().substring(2));
        審査会開催年月日.append(new RString("分"));
        return 審査会開催年月日.toRString();
    }

    private RString パターン33(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString パターン13(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }
}
