/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ConsentsToEnkitsuchiHakko;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定進捗情報を表すクラスです。
 *
 * @author N8187 久保田 英男
 */
public class YokaigoNinteiProgress {

    private final ShinseishoKanriNo 申請書管理番号;
    private final FlexibleDate 認定申請情報登録年月日;
    private final ConsentsToEnkitsuchiHakko 認定延期通知発行に対する同意有無;
    private final FlexibleDate 認定延期通知発行年月日;
    private final int 認定延期通知発行回数;
    private final RString 要介護認定延期理由;
    private final FlexibleDate 要介護認定一次判定情報抽出年月日;
    private final FlexibleDate 依頼情報データ送信年月日;
    private final FlexibleDate 認定調査依頼完了年月日;
    private final FlexibleDate 認定調査完了年月日;
    private final FlexibleDate 主治医意見書作成依頼完了年月日;
    private final FlexibleDate 主治医意見書登録完了年月日;
    private final FlexibleDate 要介護認定一次判定完了年月日;
    private final FlexibleDate 要介護認定1_5次判定完了年月日;
    private final FlexibleDate 認定審査会割当完了年月日;
    private final FlexibleDate 認定審査会完了年月日;
    private final FlexibleDate センター送信年月日;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定申請情報登録年月日 認定申請情報登録年月日
     * @param 認定延期通知発行に対する同意有無 認定延期通知発行に対する同意有無
     * @param 認定延期通知発行年月日 認定延期通知発行年月日
     * @param 認定延期通知発行回数 認定延期通知発行回数
     * @param 要介護認定延期理由 要介護認定延期理由
     * @param 要介護認定一次判定情報抽出年月日 要介護認定一次判定情報抽出年月日
     * @param 依頼情報データ送信年月日 依頼情報データ送信年月日
     * @param 認定調査依頼完了年月日 認定調査依頼完了年月日
     * @param 認定調査完了年月日 認定調査完了年月日
     * @param 主治医意見書作成依頼完了年月日 主治医意見書作成依頼完了年月日
     * @param 主治医意見書登録完了年月日 主治医意見書登録完了年月日
     * @param 要介護認定一次判定完了年月日 要介護認定一次判定完了年月日
     * @param 要介護認定1_5次判定完了年月日 要介護認定1_5次判定完了年月日
     * @param 認定審査会割当完了年月日 認定審査会割当完了年月日
     * @param 認定審査会完了年月日 認定審査会完了年月日
     * @param センター送信年月日 センター送信年月日
     */
    public YokaigoNinteiProgress(ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 認定申請情報登録年月日,
            ConsentsToEnkitsuchiHakko 認定延期通知発行に対する同意有無,
            FlexibleDate 認定延期通知発行年月日,
            int 認定延期通知発行回数,
            RString 要介護認定延期理由,
            FlexibleDate 要介護認定一次判定情報抽出年月日,
            FlexibleDate 依頼情報データ送信年月日,
            FlexibleDate 認定調査依頼完了年月日,
            FlexibleDate 認定調査完了年月日,
            FlexibleDate 主治医意見書作成依頼完了年月日,
            FlexibleDate 主治医意見書登録完了年月日,
            FlexibleDate 要介護認定一次判定完了年月日,
            FlexibleDate 要介護認定1_5次判定完了年月日,
            FlexibleDate 認定審査会割当完了年月日,
            FlexibleDate 認定審査会完了年月日,
            FlexibleDate センター送信年月日) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.認定申請情報登録年月日 = requireNonNull(認定申請情報登録年月日, Messages.E00001.replace("認定申請情報登録年月日").getMessage());
        this.認定延期通知発行に対する同意有無 = requireNonNull(認定延期通知発行に対する同意有無, Messages.E00001.replace("認定延期通知発行に対する同意有無").getMessage());
        this.認定延期通知発行年月日 = requireNonNull(認定延期通知発行年月日, Messages.E00001.replace("認定延期通知発行年月日").getMessage());
        this.認定延期通知発行回数 = requireNonNull(認定延期通知発行回数, Messages.E00001.replace("認定延期通知発行回数").getMessage());
        this.要介護認定延期理由 = requireNonNull(要介護認定延期理由, Messages.E00001.replace("要介護認定延期理由").getMessage());
        this.要介護認定一次判定情報抽出年月日 = requireNonNull(要介護認定一次判定情報抽出年月日, Messages.E00001.replace("要介護認定一次判定情報抽出年月日").getMessage());
        this.依頼情報データ送信年月日 = requireNonNull(依頼情報データ送信年月日, Messages.E00001.replace("依頼情報データ送信年月日").getMessage());
        this.認定調査依頼完了年月日 = requireNonNull(認定調査依頼完了年月日, Messages.E00001.replace("認定調査依頼完了年月日").getMessage());
        this.認定調査完了年月日 = requireNonNull(認定調査完了年月日, Messages.E00001.replace("認定調査完了年月日").getMessage());
        this.主治医意見書作成依頼完了年月日 = requireNonNull(主治医意見書作成依頼完了年月日, Messages.E00001.replace("主治医意見書作成依頼完了年月日").getMessage());
        this.主治医意見書登録完了年月日 = requireNonNull(主治医意見書登録完了年月日, Messages.E00001.replace("主治医意見書登録完了年月日").getMessage());
        this.要介護認定一次判定完了年月日 = requireNonNull(要介護認定一次判定完了年月日, Messages.E00001.replace("要介護認定一次判定完了年月日").getMessage());
        this.要介護認定1_5次判定完了年月日 = requireNonNull(要介護認定1_5次判定完了年月日, Messages.E00001.replace("要介護認定1_5次判定完了年月日").getMessage());
        this.認定審査会割当完了年月日 = requireNonNull(認定審査会割当完了年月日, Messages.E00001.replace("認定審査会割当完了年月日").getMessage());
        this.認定審査会完了年月日 = requireNonNull(認定審査会完了年月日, Messages.E00001.replace("認定審査会完了年月日").getMessage());
        this.センター送信年月日 = requireNonNull(センター送信年月日, Messages.E00001.replace("センター送信年月日").getMessage());
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 認定申請情報登録年月日を返します。
     *
     * @return 認定申請情報登録年月日
     */
    public FlexibleDate get認定申請情報登録年月日() {
        return 認定申請情報登録年月日;
    }

    /**
     * 認定延期通知発行に対する同意有無を返します。
     *
     * @return 認定延期通知発行に対する同意有無
     */
    public ConsentsToEnkitsuchiHakko has認定延期通知発行に対する同意有無() {
        return 認定延期通知発行に対する同意有無;
    }

    /**
     * 認定延期通知発行年月日を返します。
     *
     * @return 認定延期通知発行年月日
     */
    public FlexibleDate get認定延期通知発行年月日() {
        return 認定延期通知発行年月日;
    }

    /**
     * 認定延期通知発行回数を返します。
     *
     * @return 認定延期通知発行回数
     */
    public int get認定延期通知発行回数() {
        return 認定延期通知発行回数;
    }

    /**
     * 要介護認定延期理由を返します。
     *
     * @return 要介護認定延期理由
     */
    public RString get要介護認定延期理由() {
        return 要介護認定延期理由;
    }

    /**
     * 要介護認定一次判定情報抽出年月日を返します。
     *
     * @return 要介護認定一次判定情報抽出年月日
     */
    public FlexibleDate get要介護認定一次判定情報抽出年月日() {
        return 要介護認定一次判定情報抽出年月日;
    }

    /**
     * 依頼情報データ送信年月日を返します。
     *
     * @return 依頼情報データ送信年月日
     */
    public FlexibleDate get依頼情報データ送信年月日() {
        return 依頼情報データ送信年月日;
    }

    /**
     * 認定調査依頼完了年月日を返します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return 認定調査依頼完了年月日;
    }

    /**
     * 認定調査完了年月日を返します。
     *
     * @return 認定調査完了年月日
     */
    public FlexibleDate get認定調査完了年月日() {
        return 認定調査完了年月日;
    }

    /**
     * 主治医意見書作成依頼完了年月日を返します。
     *
     * @return 主治医意見書作成依頼完了年月日
     */
    public FlexibleDate get主治医意見書作成依頼完了年月日() {
        return 主治医意見書作成依頼完了年月日;
    }

    /**
     * 主治医意見書登録完了年月日を返します。
     *
     * @return 主治医意見書登録完了年月日
     */
    public FlexibleDate get主治医意見書登録完了年月日() {
        return 主治医意見書登録完了年月日;
    }

    /**
     * 要介護認定一次判定完了年月日を返します。
     *
     * @return 要介護認定一次判定完了年月日
     */
    public FlexibleDate get要介護認定一次判定完了年月日() {
        return 要介護認定一次判定完了年月日;
    }

    /**
     * 要介護認定1_5次判定完了年月日を返します。
     *
     * @return 要介護認定1_5次判定完了年月日
     */
    public FlexibleDate get要介護認定1_5次判定完了年月日() {
        return 要介護認定1_5次判定完了年月日;
    }

    /**
     * 認定審査会割当完了年月日を返します。
     *
     * @return 認定審査会割当完了年月日
     */
    public FlexibleDate get認定審査会割当完了年月日() {
        return 認定審査会割当完了年月日;
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return 認定審査会完了年月日;
    }

    /**
     * センター送信年月日を返します。
     *
     * @return センター送信年月日
     */
    public FlexibleDate getセンター送信年月日() {
        return センター送信年月日;
    }
}
