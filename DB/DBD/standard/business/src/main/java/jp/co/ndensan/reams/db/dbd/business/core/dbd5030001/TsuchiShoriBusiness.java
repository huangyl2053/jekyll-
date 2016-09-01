/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd5030001;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5030001.TsuchiShoriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 完了処理・通知書発行画面のbusinessです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public class TsuchiShoriBusiness implements Serializable {

    private final RString 証記載保険者番号;
    private final RString 市町村名称;
    private final RString 被保険者番号;
    private final AtenaMeisho 被保険者氏名;
    private final FlexibleDate 認定申請年月日;
    private final Code 認定申請区分申請時コード;
    private final Code 認定申請区分法令コード;
    private final ShinseishoKanriNo 申請書管理番号;
    private final FlexibleDate 通知完了年月日;
    private final FlexibleDate 認定結果通知書発行年月日;
    private final FlexibleDate 区分変更通知書発行年月日;
    private final FlexibleDate サービス変更通知書発行年月日;
    private final FlexibleDate 認定却下通知書発行年月日;
    private final FlexibleDate 認定取消通知書発行年月日;

    /**
     * コンストラクタです。
     *
     * @param entity TsuchiShoriEntity
     */
    public TsuchiShoriBusiness(TsuchiShoriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("完了処理・通知書発行"));
        this.証記載保険者番号 = entity.get証記載保険者番号();
        this.市町村名称 = entity.get市町村名称();
        this.被保険者番号 = entity.get被保険者番号();
        this.被保険者氏名 = entity.get被保険者氏名();
        this.認定申請年月日 = entity.get認定申請年月日();
        this.認定申請区分申請時コード = entity.get認定申請区分申請時コード();
        this.認定申請区分法令コード = entity.get認定申請区分法令コード();
        this.申請書管理番号 = entity.get申請書管理番号();
        this.通知完了年月日 = entity.get通知完了年月日();
        this.認定結果通知書発行年月日 = entity.get認定結果通知書発行年月日();
        this.区分変更通知書発行年月日 = entity.get区分変更通知書発行年月日();
        this.サービス変更通知書発行年月日 = entity.getサービス変更通知書発行年月日();
        this.認定却下通知書発行年月日 = entity.get認定却下通知書発行年月日();
        this.認定取消通知書発行年月日 = entity.get認定取消通知書発行年月日();
    }

    /**
     * 証記載保険者番号を取得する。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 市町村名称を取得する。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return 市町村名称;
    }

    /**
     * 被保険者番号を取得する。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 被保険者氏名を取得する。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return 被保険者氏名.value();
    }

    /**
     * 認定申請年月日を取得する。
     *
     * @return 認定申請年月日
     */
    public TextBoxFlexibleDate get認定申請年月日() {
        if (認定申請年月日 != null && !認定申請年月日.isEmpty()) {
            return changeFlexibleDateToTextBoxFlexibleDate(認定申請年月日);
        }
        return changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate.EMPTY);
    }

    /**
     * 認定申請区分申請時コードを取得する。
     *
     * @return 認定申請区分申請時コード
     */
    public RString get認定申請区分申請時コード() {
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.新規申請.get名称();
        } else if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.更新申請.get名称();
        } else if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.区分変更申請.get名称();
        } else if (NinteiShinseiShinseijiKubunCode.職権.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.職権.get名称();
        } else if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.転入申請.get名称();
        } else if (NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.資格喪失_死亡.get名称();
        } else if (NinteiShinseiShinseijiKubunCode.新規申請_事前.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.新規申請_事前.get名称();
        } else if (NinteiShinseiShinseijiKubunCode.更新申請_事前.getコード().equals(認定申請区分申請時コード.value())) {
            return NinteiShinseiShinseijiKubunCode.更新申請_事前.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 認定申請区分法令コードを取得する。
     *
     * @return 認定申請区分法令コード
     */
    public RString get認定申請区分法令コード() {
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(認定申請区分法令コード.value())) {
            return NinteiShinseiHoreiCode.新規申請.get名称();
        } else if (NinteiShinseiHoreiCode.更新申請.getコード().equals(認定申請区分法令コード.value())) {
            return NinteiShinseiHoreiCode.更新申請.get名称();
        } else if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(認定申請区分法令コード.value())) {
            return NinteiShinseiHoreiCode.区分変更申請.get名称();
        } else if (NinteiShinseiHoreiCode.職権.getコード().equals(認定申請区分法令コード.value())) {
            return NinteiShinseiHoreiCode.職権.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 申請書管理番号を取得する。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return 申請書管理番号.value();
    }

    /**
     * 通知完了年月日を取得する。
     *
     * @return 通知完了年月日
     */
    public TextBoxFlexibleDate get通知完了年月日() {
        if (通知完了年月日 != null && !通知完了年月日.isEmpty()) {
            return changeFlexibleDateToTextBoxFlexibleDate(通知完了年月日);
        }
        return changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate.EMPTY);
    }

    /**
     * 認定結果通知書発行年月日を取得する。
     *
     * @return 認定結果通知書発行年月日
     */
    public TextBoxFlexibleDate get認定結果通知書発行年月日() {
        if (認定結果通知書発行年月日 != null && !認定結果通知書発行年月日.isEmpty()) {
            return changeFlexibleDateToTextBoxFlexibleDate(認定結果通知書発行年月日);
        }
        return changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate.EMPTY);
    }

    /**
     * 区分変更通知書発行年月日を取得する。
     *
     * @return 区分変更通知書発行年月日
     */
    public TextBoxFlexibleDate get区分変更通知書発行年月日() {
        if (区分変更通知書発行年月日 != null && !区分変更通知書発行年月日.isEmpty()) {
            return changeFlexibleDateToTextBoxFlexibleDate(区分変更通知書発行年月日);
        }
        return changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate.EMPTY);
    }

    /**
     * サービス変更通知書発行年月日を取得する。
     *
     * @return サービス変更通知書発行年月日
     */
    public TextBoxFlexibleDate getサービス変更通知書発行年月日() {
        if (サービス変更通知書発行年月日 != null && !サービス変更通知書発行年月日.isEmpty()) {
            return changeFlexibleDateToTextBoxFlexibleDate(サービス変更通知書発行年月日);
        }
        return changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate.EMPTY);
    }

    /**
     * 認定却下通知書発行年月日を取得する。
     *
     * @return 認定却下通知書発行年月日
     */
    public TextBoxFlexibleDate get認定却下通知書発行年月日() {
        if (認定却下通知書発行年月日 != null && !認定却下通知書発行年月日.isEmpty()) {
            return changeFlexibleDateToTextBoxFlexibleDate(認定却下通知書発行年月日);
        }
        return changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate.EMPTY);
    }

    /**
     * get認定取消通知書発行年月日を取得する。
     *
     * @return get認定取消通知書発行年月日
     */
    public TextBoxFlexibleDate get認定取消通知書発行年月日() {
        if (認定取消通知書発行年月日 != null && !認定取消通知書発行年月日.isEmpty()) {
            return changeFlexibleDateToTextBoxFlexibleDate(認定取消通知書発行年月日);
        }
        return changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate.EMPTY);
    }

    private TextBoxFlexibleDate changeFlexibleDateToTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate textBoxFlexibleDate = new TextBoxFlexibleDate();
        textBoxFlexibleDate.setValue(date);
        return textBoxFlexibleDate;
    }

}
