/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事前審査結果一覧表のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-1640-020 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranBusiness {

    private static final RString NULLNONE = new RString("※");
    private static final int ZERO = 0;
    private static final int ITI = 1;
    private static final int NI = 2;
    private static final int SAN = 3;
    private static final int YON = 4;
    private static final int LOKU = 6;
    private static final RString コード99A = new RString("99A");
    private static final RString コード02A = new RString("02A");
    private static final RString コード06A = new RString("06A");
    private static final RString コード09A = new RString("09A");
    private static final RString コード09B = new RString("09B");
    private final ShinsakaiJizenshinsakekkaIchiranRelateEntity 審査会対象者情報;
    private final List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会情報;
    private final List<JizenShinsaKekkaRelateEntity> 審査員名;
    private final List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会結果情報;
    private final int データフラグ;

    /**
     * コンストラクタです
     *
     * @param 審査会対象者情報 審査会対象者情報
     * @param 審査会情報 審査会情報
     * @param 審査員名 審査員名
     * @param 審査会結果情報 審査会結果情報
     * @param データフラグ データフラグ
     */
    public ShinsakaiJizenshinsakekkaIchiranBusiness(
            ShinsakaiJizenshinsakekkaIchiranRelateEntity 審査会対象者情報,
            List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会情報,
            List<JizenShinsaKekkaRelateEntity> 審査員名,
            List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会結果情報,
            int データフラグ) {
        this.審査会対象者情報 = 審査会対象者情報;
        this.審査会情報 = 審査会情報;
        this.審査員名 = 審査員名;
        this.審査会結果情報 = 審査会結果情報;
        this.データフラグ = データフラグ;
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return set合議体番号();
    }

    /**
     * 介護認定審査会開催番号を取得します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return set介護認定審査会開催番号();
    }

    /**
     * 介護認定審査会開催予定年月日を取得します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public RString get介護認定審査会開催予定年月日() {
        return dateFormat();
    }

    /**
     * 審査員1を取得します。
     *
     * @return 審査員1
     */
    public RString get審査員1() {
        return get審査員(ZERO).getShinsakaiIinShimei();
    }

    /**
     * 審査員2を取得します。
     *
     * @return 審査員2
     */
    public RString get審査員2() {
        return get審査員(ITI).getShinsakaiIinShimei();
    }

    /**
     * 審査員3を取得します。
     *
     * @return 審査員3
     */
    public RString get審査員3() {
        return get審査員(NI).getShinsakaiIinShimei();
    }

    /**
     * 審査員4を取得します。
     *
     * @return 審査員4
     */
    public RString get審査員4() {
        return get審査員(SAN).getShinsakaiIinShimei();
    }

    /**
     * 審査員5を取得します。
     *
     * @return 審査員5
     */
    public RString get審査員5() {
        return get審査員(YON).getShinsakaiIinShimei();
    }

    /**
     * Noを取得します。
     *
     * @return No
     */
    public RString getNo() {
        return new RString(審査会対象者情報.getShinsakaiOrder());
    }

    /**
     * 特定疾病を取得します。
     *
     * @return 特定疾病
     */
    public RString get特定疾病() {
        return set特定疾病(審査会対象者情報.getNigoTokuteiShippeiCode());
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return 審査会対象者情報.getHihokenshaNo();
    }

    /**
     * 前回介護度を取得します。
     *
     * @return 前回介護度
     */
    public RString get前回介護度() {
        return set前回介護度(審査会対象者情報.getNijiHanteiYokaigoJotaiKubunCode(), 審査会対象者情報.getKoroshoIfShikibetsuCode());
    }

    /**
     * メモ1を取得します。
     *
     * @return メモ1
     */
    public RString getメモ1() {
        return RString.EMPTY;
    }

    /**
     * 判定1を取得します。
     *
     * @return 判定1
     */
    public RString get判定1() {
        return set対応結果(get審査員(ZERO).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * 期間1を取得します。
     *
     * @return 期間1
     */
    public RString get期間1() {
        return set有効期間(get審査員(ZERO).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * メモ2を取得します。
     *
     * @return メモ2
     */
    public RString getメモ2() {
        return RString.EMPTY;
    }

    /**
     * 判定2を取得します。
     *
     * @return 判定2
     */
    public RString get判定2() {
        return set対応結果(get審査員(ITI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * 期間2を取得します。
     *
     * @return 期間2
     */
    public RString get期間2() {
        return set有効期間(get審査員(ITI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * メモ3を取得します。
     *
     * @return メモ3
     */
    public RString getメモ3() {
        return RString.EMPTY;
    }

    /**
     * 判定3を取得します。
     *
     * @return 判定3
     */
    public RString get判定3() {
        return set対応結果(get審査員(NI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * 期間3を取得します。
     *
     * @return 期間3
     */
    public RString get期間3() {
        return set有効期間(get審査員(NI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * メモ4を取得します。
     *
     * @return メモ4
     */
    public RString getメモ4() {
        return RString.EMPTY;
    }

    /**
     * 判定4を取得します。
     *
     * @return 判定4
     */
    public RString get判定4() {
        return set対応結果(get審査員(SAN).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * 期間4を取得します。
     *
     * @return 期間4
     */
    public RString get期間4() {
        return set有効期間(get審査員(SAN).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * メモ5を取得します。
     *
     * @return メモ5
     */
    public RString getメモ5() {
        return RString.EMPTY;
    }

    /**
     * 判定5を取得します。
     *
     * @return 判定5
     */
    public RString get判定5() {
        return set対応結果(get審査員(YON).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * 期間5を取得します。
     *
     * @return 期間5
     */
    public RString get期間5() {
        return set有効期間(get審査員(YON).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder()));
    }

    /**
     * 一次判定を取得します。
     *
     * @return 一次判定
     */
    public RString get一次判定() {
        return set一次判定結果(審査会対象者情報.getIchijiHanteiKekkaCode(), 審査会対象者情報.getKoroshoIfShikibetsuCode());
    }

    /**
     * 二次判定を取得します。
     *
     * @return 二次判定
     */
    public RString get二次判定() {
        return RString.EMPTY;
    }

    /**
     * 区分を取得します。
     *
     * @return 区分
     */
    public RString get区分() {
        return set区分(審査会対象者情報);
    }

    /**
     * 有効期間を取得します。
     *
     * @return 有効期間
     */
    public RString get有効期間() {
        return RString.EMPTY;
    }

    /**
     * 有効期間開始年月日を取得します。
     *
     * @return 有効期間開始年月日
     */
    public RString get有効期間開始年月日() {
        return RString.EMPTY;
    }

    /**
     * 有効期間終了年月日を取得します。
     *
     * @return 有効期間終了年月日
     */
    public RString get有効期間終了年月日() {
        return RString.EMPTY;
    }

    /**
     * 一次判定の変更理由を取得します。
     *
     * @return 一次判定の変更理由
     */
    public RString get一次判定の変更理由() {
        return RString.EMPTY;
    }

    /**
     * 一致件数を取得します。
     *
     * @return 一致件数
     */
    public RString get一致件数() {
        return RString.EMPTY;
    }

    /**
     * 審査件数を取得します。
     *
     * @return 審査件数
     */
    public RString get審査件数() {
        return new RString(データフラグ);
    }

    private RString set合議体番号() {
        if (審査会情報.size() == ZERO) {
            return RString.EMPTY;
        } else {
            return new RString(審査会情報.get(ZERO).getGogitaiNo());
        }
    }

    private RString set介護認定審査会開催番号() {
        if (審査会情報.size() == ZERO) {
            return RString.EMPTY;
        } else {
            return 審査会情報.get(ZERO).getShinsakaiKaisaiNo().substring(審査会情報.get(ZERO).getShinsakaiKaisaiNo().length() - YON);
        }
    }

    private RString dateFormat() {
        if (審査会情報.isEmpty()) {
            return RString.EMPTY;
        }
        RString 年月日 = 審査会情報.get(ZERO).getShinsakaiKaisaiYoteiYMD();
        RString 時分 = 審査会情報.get(ZERO).getShinsakaiKaishiYoteiTime();
        return new RStringBuilder(年月日.substring(ZERO, YON)).append("年").append(年月日.substring(YON, LOKU))
                .append("月").append(年月日.substring(LOKU)).append("日")
                .append(" ").append(時分.substring(ZERO, NI)).append("時")
                .append(時分.substring(NI)).append("分").toRString();
    }

    private JizenShinsaKekkaRelateEntity get審査員(int 審査員フラグ) {
        if (審査員名.size() > ZERO && 審査員フラグ == ZERO) {
            return 審査員名.get(審査員フラグ);
        }
        if (審査員名.size() > ITI && 審査員フラグ == ITI) {
            return 審査員名.get(審査員フラグ);
        }
        if (審査員名.size() > NI && 審査員フラグ == NI) {
            return 審査員名.get(審査員フラグ);
        }
        if (審査員名.size() > SAN && 審査員フラグ == SAN) {
            return 審査員名.get(審査員フラグ);
        }
        if (審査員名.size() > YON && 審査員フラグ == YON) {
            return 審査員名.get(審査員フラグ);
        }
        return new JizenShinsaKekkaRelateEntity();
    }

    private RString set特定疾病(RString 特定疾病) {
        if (!RString.isNullOrEmpty(特定疾病)) {
            return NULLNONE;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set前回介護度(RString 二次判定要介護状態区分コード, RString 厚労省IF識別コード) {
        if (RString.isNullOrEmpty(二次判定要介護状態区分コード) || RString.isNullOrEmpty(厚労省IF識別コード)) {
            return RString.EMPTY;
        }
        if (コード99A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(二次判定要介護状態区分コード).get略称();
        }
        if (コード02A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(二次判定要介護状態区分コード).get略称();
        }
        if (コード06A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(二次判定要介護状態区分コード).get略称();
        }
        if (コード09A.equals(厚労省IF識別コード) || コード09B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(二次判定要介護状態区分コード).get略称();
        }
        return RString.EMPTY;
    }

    private RString set対応結果(RString 審査員コード, RString 審査順) {
        if (RString.isNullOrEmpty(審査員コード) || RString.isNullOrEmpty(審査順)) {
            return RString.EMPTY;
        }
        for (ShinsakaiJizenshinsakekkaIchiranRelateEntity entity : 審査会結果情報) {
            if (審査員コード.equals(entity.getShinsakaiIinCode()) && 審査順.equals(new RString(entity.getShinsakaiOrder()))) {
                return set前回介護度(entity.getNijiHanteiKekkaCode(), entity.getKoroshoIfShikibetsuCode());
            }
        }
        return RString.EMPTY;
    }

    private RString set有効期間(RString 審査員コード, RString 審査順) {
        if (RString.isNullOrEmpty(審査員コード) || RString.isNullOrEmpty(審査順)) {
            return RString.EMPTY;
        }
        for (ShinsakaiJizenshinsakekkaIchiranRelateEntity entity : 審査会結果情報) {
            if (審査員コード.equals(entity.getShinsakaiIinCode()) && 審査順.equals(new RString(entity.getShinsakaiOrder()))) {
                return entity.getYukokikan();
            }
        }
        return RString.EMPTY;
    }

    private RString set一次判定結果(RString 要介護認定一次判定結果コード, RString 厚労省IF識別コード) {
        if (RString.isNullOrEmpty(要介護認定一次判定結果コード) || RString.isNullOrEmpty(厚労省IF識別コード)) {
            return RString.EMPTY;
        }
        if (コード99A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(要介護認定一次判定結果コード).get名称();
        }
        if (コード02A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(要介護認定一次判定結果コード).get名称();
        }
        if (コード06A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(要介護認定一次判定結果コード).get名称();
        }
        if (コード09A.equals(厚労省IF識別コード) || コード09B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(要介護認定一次判定結果コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString set区分(ShinsakaiJizenshinsakekkaIchiranRelateEntity 審査会対象者情報) {
        if (RString.isNullOrEmpty(審査会対象者情報.getNinteiShinseiShinseijiKubunCode())) {
            return RString.EMPTY;
        } else {
            return NinteiShinseiShinseijiKubunCode.toValue(審査会対象者情報.getNinteiShinseiShinseijiKubunCode()).get名称();
        }
    }
}
