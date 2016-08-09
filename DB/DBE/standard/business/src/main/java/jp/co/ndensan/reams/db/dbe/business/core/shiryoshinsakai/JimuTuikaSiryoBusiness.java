/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaNinchishoKasanCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定追加資料鑑情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuTuikaSiryoBusiness {

    private static final int SIZE_3 = 3;
    private static final int SIZE_4 = 4;
    private static final int SIZE_5 = 5;
    private static final int SIZE_6 = 6;
    private static final int SIZE_7 = 7;
    private final ShinsakaiTaiyosyaJohoEntity entity;
    private final List<ShinsakaiIinJohoEntity> 審査員;
    private final IinShinsakaiIinJohoProcessParameter paramter;
    private final int 審査対象者数;
    private final RString 通知文;

    /**
     * コンストラクタです。
     *
     * @param entity IinTuikaSiryoEntity
     * @param 審査員 List<ShinsakaiIinJohoEntity>
     * @param paramter IinShinsakaiIinJohoProcessParameter
     * @param 審査対象者数 int
     * @param 通知文 通知文1
     */
    public JimuTuikaSiryoBusiness(
            ShinsakaiTaiyosyaJohoEntity entity,
            List<ShinsakaiIinJohoEntity> 審査員,
            IinShinsakaiIinJohoProcessParameter paramter,
            int 審査対象者数,
            RString 通知文) {
        this.entity = entity;
        this.審査員 = 審査員;
        this.paramter = paramter;
        this.審査対象者数 = 審査対象者数;
        this.通知文 = 通知文;
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
        return entity.getHihokenshaName().value();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return Seibetsu.toValue(entity.getSeibetsu().value()).get名称();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        if (entity.getAge() == 0) {
            return RString.EMPTY;
        }
        return new RString(entity.getAge());
    }

    /**
     * 前回二次を取得します。
     *
     * @return 前回二次
     */
    public RString get前回二次() {
        return get要介護状態区分(entity.getNijiHanteiYokaigoJotaiKubunCode());
    }

    /**
     * 前回期間を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間() {
        return get前回期間(entity.getNijiHanteiNinteiYukoKikan());
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
        return get要介護認定一次判定結果(entity.getIchijiHanteiKekkaCode(), entity.getIchijiHanteiKekkaNinchishoKasanCode());
    }

    /**
     * 警告を取得します。
     *
     * @return 警告
     */
    public RString get警告() {
        if (RString.isNullOrEmpty(entity.getIchijiHnateiKeikokuCode())) {
            return new RString("無");
        }
        return new RString("有");
    }

    /**
     * 前回期間_下を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間_下() {
        RStringBuilder 前回期間_下 = new RStringBuilder();
        if (entity.getNijiHanteiNinteiYukoKaishiYMD() != null && !entity.getNijiHanteiNinteiYukoKaishiYMD().isEmpty()) {
            前回期間_下.append(パターン13(entity.getNijiHanteiNinteiYukoKaishiYMD()));
            if (entity.getNijiHanteiNinteiYukoShuryoYMD() != null && !entity.getNijiHanteiNinteiYukoShuryoYMD().isEmpty()) {
                前回期間_下.append("～");
            } else {
                return 前回期間_下.toRString();
            }
        }
        if (entity.getNijiHanteiNinteiYukoShuryoYMD() != null && !entity.getNijiHanteiNinteiYukoShuryoYMD().isEmpty()) {
            前回期間_下.append(パターン13(entity.getNijiHanteiNinteiYukoShuryoYMD()));
        }
        return 前回期間_下.toRString();
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
     * 審査員1を取得します。
     *
     * @return 審査員1
     */
    public RString get審査員1() {
        if (0 < 審査員.size()) {
            return 審査員.get(0).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員2を取得します。
     *
     * @return 審査員2
     */
    public RString get審査員2() {
        if (1 < 審査員.size()) {
            return 審査員.get(1).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員3を取得します。
     *
     * @return 審査員3
     */
    public RString get審査員3() {
        if (2 < 審査員.size()) {
            return 審査員.get(2).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員4を取得します。
     *
     * @return 審査員4
     */
    public RString get審査員4() {
        if (SIZE_3 < 審査員.size()) {
            return 審査員.get(SIZE_3).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員5を取得します。
     *
     * @return 審査員5
     */
    public RString get審査員5() {
        if (SIZE_4 < 審査員.size()) {
            return 審査員.get(SIZE_4).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員6を取得します。
     *
     * @return 審査員6
     */
    public RString get審査員6() {
        if (SIZE_5 < 審査員.size()) {
            return 審査員.get(SIZE_5).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員7を取得します。
     *
     * @return 審査員7
     */
    public RString get審査員7() {
        if (SIZE_6 < 審査員.size()) {
            return 審査員.get(SIZE_6).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 審査員8を取得します。
     *
     * @return 審査員8
     */
    public RString get審査員8() {
        if (SIZE_7 < 審査員.size()) {
            return 審査員.get(SIZE_7).getShinsakaiIinShimei().value();
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
        return new RString(paramter.getGogitaiNo());
    }

    /**
     * 審査会開催年月日を取得します。
     *
     * @return 審査会開催年月日
     */
    public RString get審査会開催年月日() {
        return get開催年月日();
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
        return 通知文;
    }

    private RString get開催年月日() {
        RStringBuilder 審査会開催年月日 = new RStringBuilder();
        List<RString> 時分 = paramter.getShinsakaiKaishiYoteiTime().padZeroToLeft(SIZE_5).split(":");
        審査会開催年月日.append(paramter.getShinsakaiKaisaiYoteiYMD().getYear())
                .append(new RString("年 "))
                .append(new RString(paramter.getShinsakaiKaisaiYoteiYMD().getMonthValue()).padZeroToLeft(2))
                .append(new RString("月 "))
                .append(new RString(paramter.getShinsakaiKaisaiYoteiYMD().getDayValue()).padZeroToLeft(2))
                .append(new RString("日 "))
                .append(時分.get(0).padZeroToLeft(2))
                .append(new RString("時 "))
                .append(時分.get(1).padZeroToLeft(2))
                .append(new RString("分"));
        return 審査会開催年月日.toRString();
    }

    private RString get前回期間(int 期間) {
        if (期間 == 0) {
            return RString.EMPTY;
        }
        RStringBuilder 前回期間 = new RStringBuilder();
        前回期間.append(期間);
        前回期間.append(new RString("ヵ月"));
        return 前回期間.toRString();
    }

    private RString get要介護状態区分(Code 状態区分コード) {
        if (状態区分コード != null && !状態区分コード.isEmpty()) {
            RStringBuilder builder = new RStringBuilder("要介護状態区分コード");
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.getKoroshoIfShikibetsuCode().value())) {
                return builder.append(YokaigoJotaiKubun99.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.getKoroshoIfShikibetsuCode().value())) {
                return builder.append(YokaigoJotaiKubun02.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.getKoroshoIfShikibetsuCode().value())) {
                return builder.append(YokaigoJotaiKubun06.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.getKoroshoIfShikibetsuCode().value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.getKoroshoIfShikibetsuCode().value())) {
                return builder.append(YokaigoJotaiKubun09.toValue(状態区分コード.getColumnValue()).get名称()).toRString();
            }
        }
        return RString.EMPTY;
    }

    private RString get要介護認定一次判定結果(Code 判定結果コード, Code 認知症加算コード) {
        RStringBuilder 判定結果 = new RStringBuilder();
        判定結果.append(IchijiHanteiKekkaCode09.toValue(判定結果コード.getColumnValue()).get名称()).toRString();
        if (!判定結果コード.equals(認知症加算コード)) {
            判定結果.append("→");
            判定結果.append(IchijiHanteiKekkaNinchishoKasanCode.toValue(認知症加算コード.value()).get名称());
        }
        return 判定結果.toRString();
    }

    private RString パターン13(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }
}
