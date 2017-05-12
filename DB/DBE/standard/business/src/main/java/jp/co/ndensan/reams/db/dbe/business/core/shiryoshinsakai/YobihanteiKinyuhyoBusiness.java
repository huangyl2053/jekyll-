/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 *
 * @author n3423
 */
public class YobihanteiKinyuhyoBusiness {

    private static final int INDEX_5 = 5;
    private final HanteiJohoEntity entity;
    private final IinTokkiJikouItiziHanteiProcessParameter paramter;

    /**
     * コンストラクタです。
     *
     * @param entity HanteiJohoEntity
     * @param paramter IinTokkiJikouItiziHanteiProcessParameter
     */
    public YobihanteiKinyuhyoBusiness(
            HanteiJohoEntity entity,
            IinTokkiJikouItiziHanteiProcessParameter paramter) {
        this.entity = entity;
        this.paramter = paramter;
    }

    /**
     * 作成年月日を取得します。
     *
     * @return 作成年月日
     */
    public RString get作成年月日() {
        return get作成日期();
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
     * Noを取得します。
     *
     * @return No
     */
    public RString getNo() {
        return new RString(entity.getShinsakaiOrder());
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
        return NinteiShinseiShinseijiKubunCode.toValue(
                entity.getShinseijiKubunCode().getColumnValue()).get名称();
    }

    /**
     * 被保険者区分を取得します。
     *
     * @return 被保険者区分
     */
    public RString get被保険者区分() {
        if (RString.isNullOrEmpty(entity.getHihokenshaKubunCode())) {
            return RString.EMPTY;
        }
        return HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称();
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
        return Seibetsu.toValue(entity.getSeibetsu().getColumnValue()).get名称();
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
     * 前回二次判定を取得します。
     *
     * @return 前回二次判定
     */
    public RString get前回二次判定() {
        if (entity.getYokaigoJotaiKubunCode() == null || entity.getYokaigoJotaiKubunCode().isEmpty()) {
            return RString.EMPTY;
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.getZenKoroshoIfShikibetsuCode().getColumnValue())) {
            return YokaigoJotaiKubun99.toValue(entity.getYokaigoJotaiKubunCode().getColumnValue()).get略称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.getZenKoroshoIfShikibetsuCode().getColumnValue())) {
            return YokaigoJotaiKubun02.toValue(entity.getYokaigoJotaiKubunCode().getColumnValue()).get略称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.getZenKoroshoIfShikibetsuCode().getColumnValue())) {
            return YokaigoJotaiKubun06.toValue(entity.getYokaigoJotaiKubunCode().getColumnValue()).get略称();
        }
        return YokaigoJotaiKubun09.toValue(entity.getYokaigoJotaiKubunCode().getColumnValue()).get略称();
    }

    /**
     * 前回認定有効期間を取得します。
     *
     * @return 前回認定有効期間
     */
    public RString get前回認定有効期間() {
        if (entity.getHanteiNinteiYukoKikan() != 0) {
            return new RString(entity.getHanteiNinteiYukoKikan()).concat(new RString("ヵ月"));
        }
        return RString.EMPTY;
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
        return get要介護認定一次判定結果(entity.getKoroshoIfShikibetsuCode(),
                entity.getIchijiHanteiKekkaCode(), entity.getIchijiHanteiKekkaNinchishoKasanCode());
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
     * 状態像を取得します。
     *
     * @return 状態像
     */
    public RString get状態像() {
        return RString.EMPTY;
    }

    /**
     * 認定有効期間を取得します。
     *
     * @return 認定有効期間
     */
    public RString get認定有効期間() {
        return RString.EMPTY;
    }

    /**
     * 特定疾病コードを取得します。
     *
     * @return 特定疾病コード
     */
    public RString get特定疾病コード() {
        if (entity.getNigoTokuteiShippeiCode() == null || RString.isNullOrEmpty(entity.getNigoTokuteiShippeiCode().getColumnValue())) {
            return RString.EMPTY;
        }
        return entity.getNigoTokuteiShippeiCode().getColumnValue();
    }

    /**
     * 特定疾病名称を取得します。
     *
     * @return 特定疾病名称
     */
    public RString get特定疾病名称() {
        if (entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty()) {
            return RString.EMPTY;
        }
        return TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode().getColumnValue()).get名称();
    }

    /**
     * 調査員特記事項を取得します。
     *
     * @return 調査員特記事項
     */
    public RString get調査員特記事項() {
        return RString.EMPTY;
    }

    /**
     * 主治医意見書を取得します。
     *
     * @return 主治医意見書
     */
    public RString get主治医意見書() {
        return RString.EMPTY;
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
     * 識別コードは証記載保険者番号（左から5桁）+被保険者番号を設定してください。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.getShoKisaiHokenshaNo().substring(0, INDEX_5).concat(entity.getHihokenshaNo());
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get被保険者氏名() {
        if (entity.getHihokenshaName() == null || RString.isNullOrEmpty(entity.getHihokenshaName().getColumnValue())) {
            return RString.EMPTY;
        }
        return entity.getHihokenshaName().getColumnValue();
    }

    /**
     * 一次判定警告コードを取得します。
     *
     * @return 一次判定警告コード
     */
    public RString get一次判定警告コード() {
        if (!RString.isNullOrEmpty(entity.getIchijiHnateiKeikokuCode())) {
            int 桁位置 = entity.getIchijiHnateiKeikokuCode().indexOf(new RString("1"));
            if (桁位置 != -1) {
                return new RString(桁位置 + 1);
            } else {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.getShichosonMeisho();
    }

    /**
     * 開催年月日を取得します。
     *
     * @return 開催年月日
     */
    public FlexibleDate get開催年月日() {
        return paramter.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 開催時を取得します。
     *
     * @return 開催時
     */
    public RString get開催時() {
        return paramter.getShinsakaiKaishiYoteiTime().split(":").get(0);
    }

    /**
     * 開催分を取得します。
     *
     * @return 開催分
     */
    public RString get開催分() {
        return paramter.getShinsakaiKaishiYoteiTime().split(":").get(1);
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return paramter.getGogitaiName();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    private RString get作成日期() {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString())
                .append(" ")
                .append(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).toString())
                .append(" ")
                .append("作成")
                .toRString();
    }

    private RString get要介護認定一次判定結果(Code 厚労省IF識別コード, Code 一次判定結果コード, Code 一次判定結果コード_認知症加算) {
        RString 一次判定結果 = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (一次判定結果コード != null && !一次判定結果コード.isEmpty()
                && 厚労省IF識別コード != null && !厚労省IF識別コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun99.toValue(一次判定結果コード.getColumnValue()).get略称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun02.toValue(一次判定結果コード.getColumnValue()).get略称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun06.toValue(一次判定結果コード.getColumnValue()).get略称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果 = YokaigoJotaiKubun09.toValue(一次判定結果コード.getColumnValue()).get略称();
            }
            if (一次判定結果コード.equals(一次判定結果コード_認知症加算)) {
                return 一次判定結果;
            }
        }
        RString 一次判定結果_認知症加算 = get一次判定結果_認知症加算(厚労省IF識別コード, 一次判定結果コード_認知症加算);
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

    private RString get一次判定結果_認知症加算(Code 厚労省IF識別コード, Code 一次判定結果コード_認知症加算) {
        RString 一次判定結果_認知症加算 = RString.EMPTY;
        if (一次判定結果コード_認知症加算 != null && !一次判定結果コード_認知症加算.isEmpty()
                && 厚労省IF識別コード != null && !厚労省IF識別コード.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun99.toValue(一次判定結果コード_認知症加算.getColumnValue()).get略称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun02.toValue(一次判定結果コード_認知症加算.getColumnValue()).get略称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun06.toValue(一次判定結果コード_認知症加算.getColumnValue()).get略称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun09.toValue(一次判定結果コード_認知症加算.getColumnValue()).get略称();
            }
        }
        return 一次判定結果_認知症加算;
    }
}
