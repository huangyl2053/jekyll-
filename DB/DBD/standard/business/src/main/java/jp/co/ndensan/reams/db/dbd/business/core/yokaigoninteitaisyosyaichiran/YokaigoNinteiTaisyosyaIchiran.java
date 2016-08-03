/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.yokaigoninteitaisyosyaichiran;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteitaisyosyaichiran.YokaigoNinteiTaisyosyaIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 要介護認定処理対象者一覧画面のbusinessです。
 *
 * @reamsid_L DBD-1531-010 chenxin
 */
@lombok.Getter
public class YokaigoNinteiTaisyosyaIchiran implements Serializable {

    private static final RString コード_1 = new RString("1");
    private static final RString コード_2 = new RString("2");
    private static final RString コード_3 = new RString("3");
    private static final RString コード_4 = new RString("4");
    private static final RString コード_5 = new RString("5");
    private static final RString コード_6 = new RString("6");
    private static final RString コード_01 = new RString("01");
    private static final RString コード_06 = new RString("06");
    private static final RString コード_09 = new RString("09");
    private static final RString コード_11 = new RString("11");
    private static final RString コード_12 = new RString("12");
    private static final RString コード_13 = new RString("13");
    private static final RString コード_19 = new RString("19");
    private static final RString コード_21 = new RString("21");
    private static final RString コード_22 = new RString("22");
    private static final RString コード_23 = new RString("23");
    private static final RString コード_24 = new RString("24");
    private static final RString コード_25 = new RString("25");
    private static final RString コード_31 = new RString("31");
    private static final RString コード_32 = new RString("32");
    private static final RString コード_88 = new RString("88");
    private static final RString コード_98 = new RString("98");
    private static final RString 非該当 = new RString("非該当");
    private static final RString 事業対象外 = new RString("事業対象外");
    private static final RString みなし非該当 = new RString("みなし非該当");
    private static final RString 要支援_経過的要介護 = new RString("要支援_経過的要介護");
    private static final RString 要支援1 = new RString("要支援1");
    private static final RString 要支援2 = new RString("要支援2");
    private static final RString みなし要支援 = new RString("みなし要支援");
    private static final RString 要介護1 = new RString("要介護1");
    private static final RString 要介護2 = new RString("要介護2");
    private static final RString 要介護3 = new RString("要介護3");
    private static final RString 要介護4 = new RString("要介護4");
    private static final RString 要介護5 = new RString("要介護5");
    private static final RString 再調査 = new RString("再調査");
    private static final RString 照会 = new RString("照会");
    private static final RString 取消 = new RString("取消");
    private static final RString 保留 = new RString("保留");
    private static final RString 認定 = new RString("認定");
    private static final RString 却下 = new RString("却下");
    private static final RString 新規申請 = new RString("新規申請");
    private static final RString 更新申請 = new RString("更新申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString 職権 = new RString("職権");
    private static final RString 転入申請 = new RString("転入申請");
    private static final RString 資格喪失_死亡 = new RString("資格喪失（死亡）");

    private final DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity;
    private final AtenaMeisho 被保険者氏名;
    private final Code 取下区分コード;
    private final Code 認定申請区分申請時コード;
    private final Code 認定申請区分法令コード;
    private final FlexibleDate 認定申請年月日;

    private final ShinseishoKanriNo 受給者申請書管理番号;
    private final HihokenshaNo 受給者被保険者番号;

    private final FlexibleDate 二次判定年月日;
    private final Code 二次判定要介護状態区分コード;
    private final FlexibleDate 二次判定認定有効開始年月日;
    private final FlexibleDate 二次判定認定有効終了年月日;

    private final FlexibleDate 要介護認定一次判定年月日;
    private final Code 要介護認定一次判定結果コード認知症加算;

    /**
     * コンストラクタです。<br/>
     *
     * @param 要介護認定インターフェース情報Entity 要介護認定インターフェース情報Entity
     * @param 被保険者氏名 被保険者氏名
     * @param 取下区分コード 取下区分コード
     * @param 認定申請区分申請時コード 認定申請区分申請時コード
     * @param 認定申請区分法令コード 認定申請区分法令コード
     * @param 認定申請年月日 認定申請年月日
     * @param 受給者申請書管理番号 受給者申請書管理番号
     * @param 受給者被保険者番号 受給者被保険者番号
     * @param 二次判定年月日 二次判定年月日
     * @param 二次判定要介護状態区分コード 二次判定要介護状態区分コード
     * @param 二次判定認定有効開始年月日 二次判定認定有効開始年月日
     * @param 二次判定認定有効終了年月日 二次判定認定有効終了年月日
     * @param 要介護認定一次判定年月日 要介護認定一次判定年月日
     * @param 要介護認定一次判定結果コード認知症加算 要介護認定一次判定結果コード認知症加算
     */
    public YokaigoNinteiTaisyosyaIchiran(
            DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity,
            AtenaMeisho 被保険者氏名,
            Code 取下区分コード,
            Code 認定申請区分申請時コード,
            Code 認定申請区分法令コード,
            FlexibleDate 認定申請年月日,
            ShinseishoKanriNo 受給者申請書管理番号,
            HihokenshaNo 受給者被保険者番号,
            FlexibleDate 二次判定年月日,
            Code 二次判定要介護状態区分コード,
            FlexibleDate 二次判定認定有効開始年月日,
            FlexibleDate 二次判定認定有効終了年月日,
            FlexibleDate 要介護認定一次判定年月日,
            Code 要介護認定一次判定結果コード認知症加算
    ) {
        this.要介護認定インターフェース情報Entity = 要介護認定インターフェース情報Entity;
        this.被保険者氏名 = 被保険者氏名;
        this.取下区分コード = 取下区分コード;
        this.認定申請区分申請時コード = 認定申請区分申請時コード;
        this.認定申請区分法令コード = 認定申請区分法令コード;
        this.認定申請年月日 = 認定申請年月日;
        this.受給者申請書管理番号 = 受給者申請書管理番号;
        this.受給者被保険者番号 = 受給者被保険者番号;
        this.二次判定年月日 = 二次判定年月日;
        this.二次判定要介護状態区分コード = 二次判定要介護状態区分コード;
        this.二次判定認定有効開始年月日 = 二次判定認定有効開始年月日;
        this.二次判定認定有効終了年月日 = 二次判定認定有効終了年月日;
        this.要介護認定一次判定年月日 = 要介護認定一次判定年月日;
        this.要介護認定一次判定結果コード認知症加算 = 要介護認定一次判定結果コード認知症加算;
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 要介護認定処理対象者一覧 要介護認定処理対象者一覧
     */
    public YokaigoNinteiTaisyosyaIchiran(YokaigoNinteiTaisyosyaIchiranEntity 要介護認定処理対象者一覧) {
        requireNonNull(要介護認定処理対象者一覧, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定処理対象者一覧"));
        this.要介護認定インターフェース情報Entity = 要介護認定処理対象者一覧.get要介護認定インターフェース情報Entity();
        this.被保険者氏名 = 要介護認定処理対象者一覧.get被保険者氏名();
        this.取下区分コード = 要介護認定処理対象者一覧.get取下区分コード();
        this.認定申請区分申請時コード = 要介護認定処理対象者一覧.get認定申請区分申請時コード();
        this.認定申請区分法令コード = 要介護認定処理対象者一覧.get認定申請区分法令コード();
        this.認定申請年月日 = 要介護認定処理対象者一覧.get認定申請年月日();
        this.受給者申請書管理番号 = 要介護認定処理対象者一覧.get受給者申請書管理番号();
        this.受給者被保険者番号 = 要介護認定処理対象者一覧.get受給者被保険者番号();
        this.二次判定年月日 = 要介護認定処理対象者一覧.get二次判定年月日();
        this.二次判定要介護状態区分コード = 要介護認定処理対象者一覧.get二次判定要介護状態区分コード();
        this.二次判定認定有効開始年月日 = 要介護認定処理対象者一覧.get二次判定認定有効開始年月日();
        this.二次判定認定有効終了年月日 = 要介護認定処理対象者一覧.get二次判定認定有効終了年月日();
        this.要介護認定一次判定年月日 = 要介護認定処理対象者一覧.get要介護認定一次判定年月日();
        this.要介護認定一次判定結果コード認知症加算 = 要介護認定処理対象者一覧.get要介護認定一次判定結果コード認知症加算();

    }

    /**
     * 申請書管理番号を取得
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        ShinseishoKanriNo shinseishoKanriNo = 要介護認定インターフェース情報Entity.getShinseishoKanriNo();
        if (shinseishoKanriNo != null) {
            return shinseishoKanriNo.value();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 被保険者番号を取得
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        HihokenshaNo hihokenshaNo = 要介護認定インターフェース情報Entity.getHihokenshaNo();
        if (hihokenshaNo != null) {
            return hihokenshaNo.value();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 取下区分コードを取得
     *
     * @return 取下区分コード
     */
    public RString get取下区分コード() {
        if (TorisageKubunCode.認定申請有効.getコード().equals(要介護認定インターフェース情報Entity.getTorisageKubunCode())) {
            return TorisageKubunCode.認定申請有効.get名称();
        } else if (TorisageKubunCode.却下.getコード().equals(要介護認定インターフェース情報Entity.getTorisageKubunCode())) {
            return TorisageKubunCode.却下.get名称();
        } else {
            return null;
        }
    }

    /**
     * 申請種別コードを取得
     *
     * @return 申請種別コード
     */
    public RString get申請種別コード() {
        if (コード_1.equals(要介護認定インターフェース情報Entity.getShinseiShubetsuCode())) {
            return 新規申請;
        } else if (コード_2.equals(要介護認定インターフェース情報Entity.getShinseiShubetsuCode())) {
            return 更新申請;
        } else if (コード_3.equals(要介護認定インターフェース情報Entity.getShinseiShubetsuCode())) {
            return 区分変更申請;
        } else if (コード_4.equals(要介護認定インターフェース情報Entity.getShinseiShubetsuCode())) {
            return 職権;
        } else if (コード_5.equals(要介護認定インターフェース情報Entity.getShinseiShubetsuCode())) {
            return 転入申請;
        } else if (コード_6.equals(要介護認定インターフェース情報Entity.getShinseiShubetsuCode())) {
            return 資格喪失_死亡;
        } else {
            return null;
        }
    }

    /**
     * 予備区分4を取得
     *
     * @return 予備区分4
     */
    public RString get予備区分4() {
        if (コード_1.equals(要介護認定インターフェース情報Entity.getYobiKubun4())) {
            return 新規申請;
        } else if (コード_2.equals(要介護認定インターフェース情報Entity.getYobiKubun4())) {
            return 更新申請;
        } else if (コード_3.equals(要介護認定インターフェース情報Entity.getYobiKubun4())) {
            return 区分変更申請;
        } else if (コード_4.equals(要介護認定インターフェース情報Entity.getYobiKubun4())) {
            return 職権;
        } else {
            return null;
        }
    }

    /**
     * 認定申請日を取得
     *
     * @return 認定申請日
     */
    public TextBoxFlexibleDate get認定申請日() {
        return changeFlexibleDateToTextBoxFlexibleDate(要介護認定インターフェース情報Entity.getShinseiYMD());
    }

    /**
     * 取込日時を取得
     *
     * @return 取込日時
     */
    public RString get取込日時() {
        return 要介護認定インターフェース情報Entity.getTorikomiTimestamp().toDateString();
    }

    /**
     * 一次判定日を取得
     *
     * @return 一次判定日
     */
    public TextBoxFlexibleDate get一次判定日() {
        return changeFlexibleDateToTextBoxFlexibleDate(要介護認定インターフェース情報Entity.getIchijiHanteiYMD());
    }

    /**
     * 一次判定結果を取得
     *
     * @return 一次判定結果
     */
    public RString get一次判定結果() {
        if (コード_01.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 非該当;
        } else if (コード_06.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 事業対象外;
        } else if (コード_09.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return みなし非該当;
        } else if (コード_11.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要支援_経過的要介護;
        } else if (コード_12.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要支援1;
        } else if (コード_13.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要支援2;
        } else if (コード_19.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return みなし要支援;
        } else if (コード_21.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要介護1;
        } else if (コード_22.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要介護2;
        } else if (コード_23.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要介護3;
        } else if (コード_24.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要介護4;
        } else if (コード_25.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 要介護5;
        } else if (コード_31.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 再調査;
        } else if (コード_32.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 照会;
        } else if (コード_88.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 取消;
        } else if (コード_98.equals(要介護認定インターフェース情報Entity.getIchijiHanteiKekkaCode())) {
            return 保留;
        } else {
            return null;
        }
    }

    /**
     * 二次判定日を取得
     *
     * @return 二次判定日
     */
    public TextBoxFlexibleDate get二次判定日() {
        return changeFlexibleDateToTextBoxFlexibleDate(要介護認定インターフェース情報Entity.getNijiHanteiYMD());
    }

    /**
     * 二次判定結果を取得
     *
     * @return 二次判定結果
     */
    public RString get二次判定結果() {
        if (コード_01.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 非該当;
        } else if (コード_12.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 要支援1;
        } else if (コード_13.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 要支援2;
        } else if (コード_21.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 要介護1;
        } else if (コード_22.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 要介護2;
        } else if (コード_23.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 要介護3;
        } else if (コード_24.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 要介護4;
        } else if (コード_25.equals(要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode())) {
            return 要介護5;
        } else {
            return null;
        }
    }

    /**
     * 認定有効開始年月日を取得
     *
     * @return 認定有効開始年月日
     */
    public TextBoxFlexibleDate get認定有効開始年月日() {
        return changeFlexibleDateToTextBoxFlexibleDate(要介護認定インターフェース情報Entity.getNinteiYukoKikanStart());
    }

    /**
     * 認定有効終了年月日を取得
     *
     * @return 認定有効終了年月日
     */
    public TextBoxFlexibleDate get認定有効終了年月日() {
        return changeFlexibleDateToTextBoxFlexibleDate(要介護認定インターフェース情報Entity.getNinteiYukoKikanEnd());
    }

    /**
     * 申請情報被保険者氏名を取得
     *
     * @return 申請情報被保険者氏名
     */
    public RString get申請情報被保険者氏名() {
        return 被保険者氏名.value();
    }

    /**
     * 申請情報取下区分コードを取得
     *
     * @return 申請情報取下区分コード
     */
    public RString get申請情報取下区分コード() {
        if (コード_1.equals(取下区分コード.value())) {
            return 認定;
        } else if (コード_2.equals(取下区分コード.value())) {
            return 却下;
        } else {
            return null;
        }
    }

    /**
     * 申請情報認定申請区分申請時コードを取得
     *
     * @return 申請情報認定申請区分申請時コード
     */
    public RString get申請情報認定申請区分申請時コード() {
        if (コード_1.equals(認定申請区分申請時コード.value())) {
            return 新規申請;
        } else if (コード_2.equals(認定申請区分申請時コード.value())) {
            return 更新申請;
        } else if (コード_3.equals(認定申請区分申請時コード.value())) {
            return 区分変更申請;
        } else if (コード_4.equals(認定申請区分申請時コード.value())) {
            return 職権;
        } else if (コード_5.equals(認定申請区分申請時コード.value())) {
            return 転入申請;
        } else if (コード_6.equals(認定申請区分申請時コード.value())) {
            return 資格喪失_死亡;
        } else {
            return null;
        }
    }

    /**
     * 申請情報認定申請区分法令コードを取得
     *
     * @return 申請情報認定申請区分法令コード
     */
    public RString get申請情報認定申請区分法令コード() {
        if (コード_1.equals(認定申請区分法令コード.value())) {
            return 新規申請;
        } else if (コード_2.equals(認定申請区分法令コード.value())) {
            return 更新申請;
        } else if (コード_3.equals(認定申請区分法令コード.value())) {
            return 区分変更申請;
        } else if (コード_4.equals(認定申請区分法令コード.value())) {
            return 職権;
        } else {
            return null;
        }
    }

    /**
     * 申請情報認定申請年月日を取得
     *
     * @return 申請情報認定申請年月日
     */
    public TextBoxFlexibleDate get申請情報認定申請年月日() {
        return changeFlexibleDateToTextBoxFlexibleDate(認定申請年月日);
    }

    /**
     * 受給者申請書管理番号を取得
     *
     * @return 受給者申請書管理番号
     */
    public RString get受給者申請書管理番号() {
        return 受給者申請書管理番号.value();
    }

    /**
     * 受給者被保険者番号を取得
     *
     * @return 受給者被保険者番号
     */
    public RString get受給者被保険者番号() {
        return 受給者被保険者番号.value();
    }

    /**
     * 結果情報二次判定年月日を取得
     *
     * @return 結果情報二次判定年月日
     */
    public TextBoxFlexibleDate get結果情報二次判定年月日() {
        return changeFlexibleDateToTextBoxFlexibleDate(二次判定年月日);
    }

    /**
     * 結果情報二次判定要介護状態区分コードを取得
     *
     * @return 結果情報二次判定要介護状態区分コード
     */
    public RString get結果情報二次判定要介護状態区分コード() {
        if (コード_01.equals(二次判定要介護状態区分コード.value())) {
            return 非該当;
        } else if (コード_12.equals(二次判定要介護状態区分コード.value())) {
            return 要支援1;
        } else if (コード_13.equals(二次判定要介護状態区分コード.value())) {
            return 要支援2;
        } else if (コード_21.equals(二次判定要介護状態区分コード.value())) {
            return 要介護1;
        } else if (コード_22.equals(二次判定要介護状態区分コード.value())) {
            return 要介護2;
        } else if (コード_23.equals(二次判定要介護状態区分コード.value())) {
            return 要介護3;
        } else if (コード_24.equals(二次判定要介護状態区分コード.value())) {
            return 要介護4;
        } else if (コード_25.equals(二次判定要介護状態区分コード.value())) {
            return 要介護5;
        } else {
            return null;
        }
    }

    /**
     * 結果情報二次判定認定有効開始年月日を取得
     *
     * @return 結果情報二次判定認定有効開始年月日
     */
    public TextBoxFlexibleDate get結果情報二次判定認定有効開始年月日() {

        return changeFlexibleDateToTextBoxFlexibleDate(二次判定認定有効開始年月日);
    }

    /**
     * 結果情報二次判定認定有効終了年月日を取得
     *
     * @return 結果情報二次判定認定有効終了年月日
     */
    public TextBoxFlexibleDate get結果情報二次判定認定有効終了年月日() {
        return changeFlexibleDateToTextBoxFlexibleDate(二次判定認定有効終了年月日);
    }

    /**
     * 要介護認定一次判定年月日を取得
     *
     * @return 要介護認定一次判定年月日
     */
    public TextBoxFlexibleDate get要介護認定一次判定年月日() {
        return changeFlexibleDateToTextBoxFlexibleDate(要介護認定一次判定年月日);
    }

    /**
     * 要介護認定一次判定結果コード認知症加算を取得
     *
     * @return 要介護認定一次判定結果コード認知症加算
     */
    public RString get要介護認定一次判定結果コード認知症加算() {
        if (コード_01.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 非該当;
        } else if (コード_06.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 事業対象外;
        } else if (コード_09.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return みなし非該当;
        } else if (コード_11.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要支援_経過的要介護;
        } else if (コード_12.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要支援1;
        } else if (コード_13.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要支援2;
        } else if (コード_19.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return みなし要支援;
        } else if (コード_21.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要介護1;
        } else if (コード_22.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要介護2;
        } else if (コード_23.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要介護3;
        } else if (コード_24.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要介護4;
        } else if (コード_25.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 要介護5;
        } else if (コード_31.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 再調査;
        } else if (コード_32.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 照会;
        } else if (コード_88.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 取消;
        } else if (コード_98.equals(要介護認定一次判定結果コード認知症加算.value())) {
            return 保留;
        } else {
            return null;
        }
    }

    private TextBoxFlexibleDate changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate textBoxFlexibleDate = new TextBoxFlexibleDate();
        textBoxFlexibleDate.setValue(date);
        return textBoxFlexibleDate;
    }

}
