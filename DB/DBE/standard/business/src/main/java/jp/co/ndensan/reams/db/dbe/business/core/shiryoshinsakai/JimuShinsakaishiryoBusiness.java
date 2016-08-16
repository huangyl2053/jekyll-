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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査対象者一覧表情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuShinsakaishiryoBusiness {

    private static final int SIZE_3 = 3;
    private static final int SIZE_4 = 4;
    private static final int SIZE_5 = 5;
    private static final int SIZE_6 = 6;
    private static final int SIZE_7 = 7;
    private final IinShinsakaiIinJohoProcessParameter paramter;
    private final ShinsakaiTaiyosyaJohoEntity johoEntity;
    private final List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private final int no;
    private final int count;

    /**
     * コンストラクタです。
     *
     * @param paramter IinShinsakaiIinJohoMyBatisParameter
     * @param johoEntity ShinsakaiTaiyosyaJohoEntity
     * @param shinsakaiIinJohoList List<ShinsakaiIinJohoEntity>
     * @param no 審査対象者一覧No
     * @param count 審査対象者数
     */
    public JimuShinsakaishiryoBusiness(
            IinShinsakaiIinJohoProcessParameter paramter,
            ShinsakaiTaiyosyaJohoEntity johoEntity,
            List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList,
            int no,
            int count) {
        this.paramter = paramter;
        this.johoEntity = johoEntity;
        this.shinsakaiIinJohoList = shinsakaiIinJohoList;
        this.no = no;
        this.count = count;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return johoEntity.getShinseishoKanriNo();
    }

    /**
     * 審査会番号を取得します。
     *
     * @return 審査会番号
     */
    public RString get審査会番号() {
        return paramter.getShinsakaiKaisaiNo();
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
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return new RString(paramter.getGogitaiNo());
    }

    /**
     * 審査対象者数を取得します。
     *
     * @return 審査対象者数
     */
    public RString get審査対象者数() {
        return new RString(count);
    }

    /**
     * shinsakaiIinJohoList1を取得します。
     *
     * @return shinsakaiIinJohoList1
     */
    public RString getshinsakaiIinJohoList1() {
        if (shinsakaiIinJohoList != null && 0 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(0).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * shinsakaiIinJohoList2を取得します。
     *
     * @return shinsakaiIinJohoList2
     */
    public RString getshinsakaiIinJohoList2() {
        if (shinsakaiIinJohoList != null && 1 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(1).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * shinsakaiIinJohoList3を取得します。
     *
     * @return shinsakaiIinJohoList3
     */
    public RString getshinsakaiIinJohoList3() {
        if (shinsakaiIinJohoList != null && 2 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(2).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * shinsakaiIinJohoList4を取得します。
     *
     * @return shinsakaiIinJohoList4
     */
    public RString getshinsakaiIinJohoList4() {
        if (shinsakaiIinJohoList != null && SIZE_3 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(SIZE_3).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * shinsakaiIinJohoList5を取得します。
     *
     * @return shinsakaiIinJohoList5
     */
    public RString getshinsakaiIinJohoList5() {
        if (shinsakaiIinJohoList != null && SIZE_4 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(SIZE_4).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * shinsakaiIinJohoList6を取得します。
     *
     * @return shinsakaiIinJohoList6
     */
    public RString getshinsakaiIinJohoList6() {
        if (shinsakaiIinJohoList != null && SIZE_5 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(SIZE_5).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * shinsakaiIinJohoList7を取得します。
     *
     * @return shinsakaiIinJohoList7
     */
    public RString getshinsakaiIinJohoList7() {
        if (shinsakaiIinJohoList != null && SIZE_6 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(SIZE_6).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * shinsakaiIinJohoList8を取得します。
     *
     * @return shinsakaiIinJohoList8
     */
    public RString getshinsakaiIinJohoList8() {
        if (shinsakaiIinJohoList != null && SIZE_7 < shinsakaiIinJohoList.size()) {
            return shinsakaiIinJohoList.get(SIZE_7).getShinsakaiIinShimei().value();
        }
        return RString.EMPTY;
    }

    /**
     * 番号を取得します。
     *
     * @return no
     */
    public int getNo() {
        return no + 1;
    }

    /**
     * 審査会審査順を取得します。
     *
     * @return 審査会審査順
     */
    public RString get審査会審査順() {
        return new RString(johoEntity.getShinsakaiOrder());
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return johoEntity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者を取得します。
     *
     * @return 被保険者
     */
    public RString get被保険者() {
        return johoEntity.getHihokenshaNo();
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return johoEntity.getHihokenshaName().getColumnValue();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        if (johoEntity.getAge() == 0) {
            return RString.EMPTY;
        }
        return new RString(johoEntity.getAge());
    }

    /**
     * 前回二次を取得します。
     *
     * @return 前回二次
     */
    public RString get前回二次() {
        return get要介護状態区分(johoEntity.getKoroshoIfShikibetsuCode(), johoEntity.getNijiHanteiYokaigoJotaiKubunCode());
    }

    /**
     * 前回期間を取得します。
     *
     * @return 前回期間
     */
    public RString get前回期間() {
        return get前回期間(johoEntity.getNijiHanteiNinteiYukoKikan());
    }

    /**
     * 一次判定を取得します。
     *
     * @return 一次判定
     */
    public RString get一次判定() {
        return get要介護認定一次判定結果(johoEntity.getKoroshoIfShikibetsuCode(),
                johoEntity.getIchijiHanteiKekkaCode(), johoEntity.getIchijiHanteiKekkaNinchishoKasanCode());
    }

    /**
     * 警告を取得します。
     *
     * @return 警告
     */
    public RString get警告() {
        if (RString.isNullOrEmpty(johoEntity.getIchijiHnateiKeikokuCode())) {
            return new RString("無");
        }
        return new RString("有");
    }

    /**
     * 基準時間を取得します。
     *
     * @return 基準時間
     */
    public RString get基準時間() {
        return new RString(johoEntity.getKijunJikan());
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return Seibetsu.toValue(johoEntity.getSeibetsu().getColumnValue()).get名称();
    }

    /**
     * 二次判定を取得します。
     *
     * @return 二次判定
     */
    public RString get二次判定() {
        return get要介護状態区分(johoEntity.getKoroshoIfShikibetsuCode(), johoEntity.getNijiHanteiYokaigoJotaiKubunCode());
    }

    /**
     * 事務局を判定します。
     *
     * @return is事務局、「true」を返却する場合、事務局です、それ以外、事務局ではない。
     */
    public boolean is事務局() {
        return johoEntity.isJimukyoku();
    }

    /**
     * 前回期間_下を取得します。
     *
     * @return 前回期間_下
     */
    public RString get前回期間_下() {
        RStringBuilder 前回期間_下 = new RStringBuilder();
        if (johoEntity.getNijiHanteiNinteiYukoKaishiYMD() != null && !johoEntity.getNijiHanteiNinteiYukoKaishiYMD().isEmpty()) {
            前回期間_下.append(パターン13(johoEntity.getNijiHanteiNinteiYukoKaishiYMD()));
            if (johoEntity.getNijiHanteiNinteiYukoShuryoYMD() != null && !johoEntity.getNijiHanteiNinteiYukoShuryoYMD().isEmpty()) {
                前回期間_下.append("～");
            } else {
                return 前回期間_下.toRString();
            }
        }
        if (johoEntity.getNijiHanteiNinteiYukoShuryoYMD() != null && !johoEntity.getNijiHanteiNinteiYukoShuryoYMD().isEmpty()) {
            前回期間_下.append(パターン13(johoEntity.getNijiHanteiNinteiYukoShuryoYMD()));
        }
        return 前回期間_下.toRString();
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

    private RString get要介護状態区分(Code 厚労省IF識別コード, Code 状態区分コード) {
        if (状態区分コード != null && !状態区分コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                return YokaigoJotaiKubun99.toValue(状態区分コード.value()).get略称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                return YokaigoJotaiKubun02.toValue(状態区分コード.value()).get略称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                return YokaigoJotaiKubun06.toValue(状態区分コード.value()).get略称();
            }
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                return YokaigoJotaiKubun09.toValue(状態区分コード.value()).get略称();
            }
        }
        return RString.EMPTY;
    }

    private RString get要介護認定一次判定結果(Code 厚労省IF識別コード, Code 一次判定結果コード, Code 一次判定結果コード_認知症加算) {
        RString 一次判定結果 = RString.EMPTY;
        RString 一次判定結果_認知症加算 = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (一次判定結果コード != null && !一次判定結果コード.isEmpty()
                && 厚労省IF識別コード != null && !厚労省IF識別コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun99.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun02.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun06.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun09.toValue(一次判定結果コード.getColumnValue()).get名称();
            }
        }
        if (一次判定結果コード_認知症加算 != null && !一次判定結果コード_認知症加算.isEmpty()
                && 厚労省IF識別コード != null && !厚労省IF識別コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun99.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun02.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun06.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun09.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            }
        }
        if (!RString.isNullOrEmpty(一次判定結果) && !RString.isNullOrEmpty(一次判定結果_認知症加算)) {
            return builder.append(一次判定結果)
                    .append("→")
                    .append(一次判定結果_認知症加算).toRString();
        } else if (RString.isNullOrEmpty(一次判定結果) && !RString.isNullOrEmpty(一次判定結果_認知症加算)) {
            return builder.append(一次判定結果_認知症加算).toRString();
        } else if (!RString.isNullOrEmpty(一次判定結果) && RString.isNullOrEmpty(一次判定結果_認知症加算)) {
            return builder.append(一次判定結果).toRString();
        }
        return RString.EMPTY;
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

    private RString パターン13(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }
}
