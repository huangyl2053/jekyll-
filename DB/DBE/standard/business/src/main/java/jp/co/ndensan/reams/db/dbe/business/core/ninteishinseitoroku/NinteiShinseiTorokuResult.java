/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.NinteiShinseiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査依頼受付／みなし２号審査受付のビジネスクラスです
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class NinteiShinseiTorokuResult {

    private final NinteiShinseiTorokuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 審査依頼受付_みなし２号審査受付RelateEntity
     */
    public NinteiShinseiTorokuResult(NinteiShinseiTorokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 申請種別を取得します。
     *
     * @return 申請種別
     */
    public Code get申請種別() {
        return entity.get申請種別();
    }

    /**
     * 申請書区分を取得します。
     *
     * @return 申請書区分
     */
    public RString get申請書区分() {
        return entity.get申請書区分();
    }

    /**
     * 申請状況を取得します。
     *
     * @return 申請状況
     */
    public RString get申請状況() {
        return entity.get申請状況();
    }

    /**
     * 申請日を取得します。
     *
     * @return 申請日
     */
    public FlexibleDate get申請日() {
        return entity.get申請日();
    }

    /**
     * 認定申請区分法令コードを取得します。
     *
     * @return 認定申請区分法令コード
     */
    public Code get認定申請区分法令コード() {
        return entity.get認定申請区分法令コード();
    }

    /**
     * 認定申請区分申請時コードを取得します。
     *
     * @return 認定申請区分申請時コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.get認定申請区分申請時コード();
    }

    /**
     * 支所コードを取得します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return entity.get支所コード();
    }

    /**
     * 旧措置者フラグを取得します。
     *
     * @return 旧措置者フラグ
     */
    public boolean is旧措置者フラグ() {
        return entity.is旧措置者フラグ();
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.get被保険者区分コード();
    }

    /**
     * 資格取得前申請フラグを取得します。
     *
     * @return 資格取得前申請フラグ
     */
    public boolean is資格取得前申請フラグ() {
        return entity.is資格取得前申請フラグ();
    }

    /**
     * 二号特定疾病コードを取得します。
     *
     * @return 二号特定疾病コード
     */
    public Code get二号特定疾病コード() {
        return entity.get二号特定疾病コード();
    }

    /**
     * 認定申請理由を取得します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return entity.get認定申請理由();
    }

    /**
     * 申請サービス削除の理由を取得します。
     *
     * @return 申請サービス削除の理由
     */
    public RString get申請サービス削除の理由() {
        return entity.get申請サービス削除の理由();
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.get主治医コード();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.get主治医氏名();
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.get主治医医療機関コード();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 指定医フラグを取得します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return entity.is指定医フラグ();
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.get認定調査委託先コード();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.get事業者名称();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.get認定調査員コード();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.get調査員氏名();
    }

    /**
     * 訪問調査先名称を取得します。
     *
     * @return 訪問調査先名称
     */
    public AtenaMeisho get訪問調査先名称() {
        return entity.get訪問調査先名称();
    }

    /**
     * 訪問調査先郵便番号を取得します。
     *
     * @return 訪問調査先郵便番号
     */
    public YubinNo get訪問調査先郵便番号() {
        return entity.get訪問調査先郵便番号();
    }

    /**
     * 訪問調査先住所を取得します。
     *
     * @return 訪問調査先住所
     */
    public AtenaJusho get訪問調査先住所() {
        return entity.get訪問調査先住所();
    }

    /**
     * 訪問調査先電話番号を取得します。
     *
     * @return 訪問調査先電話番号
     */
    public TelNo get訪問調査先電話番号() {
        return entity.get訪問調査先電話番号();
    }

    /**
     * 前回要介護状態区分コードを取得します。
     *
     * @return 前回要介護状態区分コード
     */
    public Code get前回要介護状態区分コード() {
        return entity.get前回要介護状態区分コード();
    }

    /**
     * 前回認定年月日を取得します。
     *
     * @return 前回認定年月日
     */
    public FlexibleDate get前回認定年月日() {
        return entity.get前回認定年月日();
    }

    /**
     * 前回認定有効期間開始を取得します。
     *
     * @return 前回認定有効期間開始
     */
    public FlexibleDate get前回認定有効期間開始() {
        return entity.get前回認定有効期間開始();
    }

    /**
     * 前回認定有効期間終了を取得します。
     *
     * @return 前回認定有効期間終了
     */
    public FlexibleDate get前回認定有効期間終了() {
        return entity.get前回認定有効期間終了();
    }

    /**
     * 異動事由を取得します。
     *
     * @return 異動事由
     */
    public Code get異動事由() {
        return entity.get異動事由();
    }

    /**
     * 削除事由コードを取得します。
     *
     * @return 削除事由コード
     */
    public Code get削除事由コード() {
        return entity.get削除事由コード();
    }

    /**
     * 理由を取得します。
     *
     * @return 理由
     */
    public RString get理由() {
        return entity.get理由();
    }

    /**
     * 喪失年月日を取得します。
     *
     * @return 喪失年月日
     */
    public FlexibleDate get喪失年月日() {
        return entity.get喪失年月日();
    }

    /**
     * 取下年月日を取得します。
     *
     * @return 取下年月日
     */
    public FlexibleDate get取下年月日() {
        return entity.get取下年月日();
    }

    /**
     * 当初認定有効開始年月日を取得します。
     *
     * @return 当初認定有効開始年月日
     */
    public FlexibleDate get当初認定有効開始年月日() {
        return entity.get当初認定有効開始年月日();
    }

    /**
     * 当初認定有効終了年月日を取得します。
     *
     * @return 当初認定有効終了年月日
     */
    public FlexibleDate get当初認定有効終了年月日() {
        return entity.get当初認定有効終了年月日();
    }

    /**
     * 受給資格証明書発行年月日１を取得します。
     *
     * @return 受給資格証明書発行年月日１
     */
    public FlexibleDate get受給資格証明書発行年月日１() {
        return entity.get受給資格証明書発行年月日１();
    }

    /**
     * 受給資格証明書発行年月日２を取得します。
     *
     * @return 受給資格証明書発行年月日２
     */
    public FlexibleDate get受給資格証明書発行年月日２() {
        return entity.get受給資格証明書発行年月日２();
    }

    /**
     * 台帳種別を取得します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return entity.get台帳種別();
    }

    /**
     * 入所施設種類を取得します。
     *
     * @return 入所施設種類
     */
    public RString get入所施設種類() {
        return entity.get入所施設種類();
    }

    /**
     * 入所施設コードを取得します。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return entity.get入所施設コード();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 要介護認定状態区分コードを取得します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return entity.get要介護認定状態区分コード();
    }

    /**
     * 認定有効期間開始年月日を取得します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.get認定有効期間開始年月日();
    }

    /**
     * 認定有効期間終了年月日を取得します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.get認定有効期間終了年月日();
    }

    /**
     * 認定年月日を取得します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return entity.get認定年月日();
    }

    /**
     * 介護認定審査会意見を取得します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        return entity.get介護認定審査会意見();
    }

    /**
     * 市町村連絡事項を取得します。
     *
     * @return 市町村連絡事項
     */
    public RString get市町村連絡事項() {
        return entity.get市町村連絡事項();
    }

    /**
     * 主治医への連絡事項を取得します。
     *
     * @return 主治医への連絡事項
     */
    public RString get主治医への連絡事項() {
        return entity.get主治医への連絡事項();
    }

    /**
     * 調査員への連絡事項を取得します。
     *
     * @return 調査員への連絡事項
     */
    public RString get調査員への連絡事項() {
        return entity.get調査員への連絡事項();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.get識別コード();
    }
}
