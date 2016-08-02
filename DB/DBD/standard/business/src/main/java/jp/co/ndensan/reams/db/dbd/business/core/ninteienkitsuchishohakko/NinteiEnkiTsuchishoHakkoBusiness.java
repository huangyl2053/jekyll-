/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.ninteienkitsuchishohakko;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteienkitsuchishohakko.NinteiEnkiTsuchishoHakkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定延期通知発行 発行対象者一覧情報です。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
public class NinteiEnkiTsuchishoHakkoBusiness {

    private final NinteiEnkiTsuchishoHakkoEntity 発行対象者一覧情報;

    /**
     * コンストラクタです。
     *
     * @param 発行対象者一覧情報 発行対象者一覧情報
     */
    public NinteiEnkiTsuchishoHakkoBusiness(NinteiEnkiTsuchishoHakkoEntity 発行対象者一覧情報) {
        requireNonNull(発行対象者一覧情報, UrSystemErrorMessages.値がnull.getReplacedMessage("発行対象者一覧情報のエンティティ"));
        this.発行対象者一覧情報 = 発行対象者一覧情報;
    }

    /**
     * 一次判定日を返します。
     *
     * @return 一次判定日
     */
    public FlexibleDate get一次判定日() {
        return 発行対象者一覧情報.get一次判定日();
    }

    /**
     * 審査会予定日を返します。
     *
     * @return 審査会予定日
     */
    public FlexibleDate get審査会予定日() {
        return 発行対象者一覧情報.get審査会予定日();
    }

    /**
     * 延期決定日を返します。
     *
     * @return 延期決定日
     */
    public FlexibleDate get延期決定日() {
        return 発行対象者一覧情報.get延期決定日();
    }

    /**
     * 延期見込み期間終了日を返します。
     *
     * @return 延期見込み期間終了日
     */
    public FlexibleDate get延期見込み期間終了日() {
        return 発行対象者一覧情報.get延期見込み期間終了日();
    }

    /**
     * 延期見込み期間開始日を返します。
     *
     * @return 延期見込み期間開始日
     */
    public FlexibleDate get延期見込み期間開始日() {
        return 発行対象者一覧情報.get延期見込み期間開始日();
    }

    /**
     * 意見書受領日を返します。
     *
     * @return 意見書受領日
     */
    public FlexibleDate get意見書受領日() {
        return 発行対象者一覧情報.get意見書受領日();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return 発行対象者一覧情報.get認定申請年月日();
    }

    /**
     * 調査実施日を返します。
     *
     * @return 調査実施日
     */
    public FlexibleDate get調査実施日() {
        return 発行対象者一覧情報.get調査実施日();
    }

    /**
     * 通知書発行日を返します。
     *
     * @return 通知書発行日
     */
    public FlexibleDate get通知書発行日() {
        return 発行対象者一覧情報.get通知書発行日();
    }

    /**
     * 延期回数を返します。
     *
     * @return 延期回数
     */
    public int get延期回数() {
        return 発行対象者一覧情報.get延期回数();
    }

    /**
     * 延期理由を返します。
     *
     * @return 延期理由
     */
    public RString get延期理由() {
        return 発行対象者一覧情報.get延期理由();
    }

    /**
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return 発行対象者一覧情報.get保険者名();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return 発行対象者一覧情報.get氏名();
    }

    /**
     * 氏名カナを返します。
     *
     * @return 氏名カナ
     */
    public RString get氏名カナ() {
        return 発行対象者一覧情報.get氏名カナ();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return 発行対象者一覧情報.get申請書管理番号();
    }

    /**
     * 被保番号を返します。
     *
     * @return 被保番号
     */
    public RString get被保番号() {
        return 発行対象者一覧情報.get被保番号();
    }

    /**
     * 申請区分_申請時_コードを返します。
     *
     * @return 申請区分_申請時_コード
     */
    public Code get申請区分_申請時_コード() {
        return 発行対象者一覧情報.get申請区分_申請時_コード();
    }
}
