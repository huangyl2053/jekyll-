/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosaocrtorikomi;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosaocrtorikomi.ChosaOCRTorikomiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査結果登録を管理するクラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
public class ChosaOCRTorikomiBusiness {

    private final ChosaOCRTorikomiRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ChosaOCRTorikomiRelateEntity}より{@link ShujiiJoho}を生成します。
     *
     * @param entity DBより取得した{@link ChosaOCRTorikomiRelateEntity}
     */
    public ChosaOCRTorikomiBusiness(ChosaOCRTorikomiRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査結果情報"));
    }

    /**
     * 審査会名称を返します。
     *
     * @return 審査会名称
     */
    public RString get審査会名称() {
        return entity.get審査会名称();
    }

    /**
     * 合議体名称を返します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.get合議体名称();
    }

    /**
     * 介護認定審査会割当済み人数を返します。
     *
     * @return 介護認定審査会割当済み人数
     */
    public int get介護認定審査会割当済み人数() {
        return entity.get介護認定審査会割当済み人数();
    }

    /**
     * 介護認定審査会実施人数を返します。
     *
     * @return 介護認定審査会実施人数
     */
    public int get介護認定審査会実施人数() {
        return entity.get介護認定審査会実施人数();
    }

    /**
     * 介護認定審査会進捗状況を返します。
     *
     * @return 介護認定審査会進捗状況
     */
    public Code get介護認定審査会進捗状況() {
        return entity.get介護認定審査会進捗状況();
    }

    /**
     * 介護認定審査会開催場所名称を返します。
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString get介護認定審査会開催場所名称() {
        return entity.get介護認定審査会開催場所名称();
    }

    /**
     * 介護認定審査会開催地区コードを返します。
     *
     * @return 介護認定審査会開催地区コード
     */
    public Code get介護認定審査会開催地区コード() {
        return entity.get介護認定審査会開催地区コード();
    }

    /**
     * 介護認定審査会開催年月日を返します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.get介護認定審査会開催年月日();
    }

    /**
     * 介護認定審査会開始時刻を返します。
     *
     * @return 介護認定審査会開始時刻
     */
    public RString get介護認定審査会開始時刻() {
        return entity.get介護認定審査会開始時刻();
    }

    /**
     * 介護認定審査会終了時刻を返します。
     *
     * @return 介護認定審査会終了時刻
     */
    public RString get介護認定審査会終了時刻() {
        return entity.get介護認定審査会終了時刻();
    }

    /**
     * Noを返します。
     *
     * @return No
     */
    public int getNo() {
        return entity.getNo();
    }

    /**
     * 保険者を返します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.get保険者();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.get厚労省IF識別コード();
    }

    /**
     * 申請日を返します。
     *
     * @return 申請日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * 認定申請区分申請時コードを返します。
     *
     * @return 認定申請区分申請時コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.get認定申請区分申請時コード();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code get要介護認定一次判定結果コード() {
        return entity.get要介護認定一次判定結果コード();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定要介護状態区分コード() {
        return entity.get二次判定要介護状態区分コード();
    }

    /**
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate get二次判定年月日() {
        return entity.get二次判定年月日();
    }

    /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日
     */
    public FlexibleDate get二次判定認定有効終了年月日() {
        return entity.get二次判定認定有効終了年月日();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 介護認定審査会開催予定場所コードを返します。
     *
     * @return 介護認定審査会開催予定場所コード
     */
    public RString get介護認定審査会開催予定場所コード() {
        return entity.get介護認定審査会開催予定場所コード();
    }

    /**
     * イメージ共有ファイルIDを返します。
     *
     * @return イメージ共有ファイルID
     */
    public RDateTime getイメージ共有ファイルID() {
        return entity.getイメージ共有ファイルID();
    }
}
