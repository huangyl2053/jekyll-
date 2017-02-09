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
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
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
     * 申請書区分を取得します。
     *
     * @return 申請書区分
     */
    public RString get申請書区分() {
        return entity.get申請書区分();
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
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.get被保険者区分コード();
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
     * 取下年月日を取得します。
     *
     * @return 取下年月日
     */
    public FlexibleDate get取下年月日() {
        return entity.get取下年月日();
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
    
    /**
     * 申請届出代行区分コードを取得します。
     *
     * @return 申請届出代行区分コード
     */
    public Code get申請届出代行区分コード() {
        return entity.get申請届出代行区分コード();
    }
    
    /**
     * 申請届出者氏名を取得します。
     *
     * @return 申請届出者氏名
     */
    public RString get申請届出者氏名() {
        return entity.get申請届出者氏名();
    }
    
    /**
     * 申請届出者氏名カナを取得します。
     *
     * @return 申請届出者氏名カナ
     */
    public RString get申請届出者氏名カナ() {
        return entity.get申請届出者氏名カナ();
    }
    
    /**
     * 申請届出者続柄を取得します。
     *
     * @return 申請届出者続柄
     */
    public RString get申請届出者続柄() {
        return entity.get申請届出者続柄();
    }
    
    /**
     * 申請届出代行事業者番号を取得します。
     *
     * @return 申請届出代行事業者番号
     */
    public JigyoshaNo get申請届出代行事業者番号() {
        return entity.get申請届出代行事業者番号();
    }
    
    /**
     * 事業者区分を取得します。
     *
     * @return 事業者区分
     */
    public RString get事業者区分() {
        return entity.get事業者区分();
    }
    
    /**
     * 申請届出者郵便番号を取得します。
     *
     * @return 申請届出者郵便番号
     */
    public YubinNo get申請届出者郵便番号() {
        return entity.get申請届出者郵便番号();
    }
    
    /**
     * 申請届出者住所を取得します。
     *
     * @return 申請届出者住所
     */
    public RString get申請届出者住所() {
        return entity.get申請届出者住所();
    }
    
    /**
     * 申請届出者電話番号を取得します。
     *
     * @return 申請届出者電話番号
     */
    public TelNo get申請届出者電話番号() {
        return entity.get申請届出者電話番号();
    }
    
    /**
     * 取下区分コードを取得します。
     *
     * @return 取下区分コード
     */
    public Code get取下区分コード() {
        return entity.get取下区分コード();
    }
    
    /**
     * 取下理由を取得します。
     *
     * @return 取下理由
     */
    public RString get取下理由() {
        return entity.get取下理由();
    }
    
    /**
     * 延期決定年月日を取得します。
     *
     * @return 延期決定年月日
     */
    public FlexibleDate get延期決定年月日() {
        return entity.get延期決定年月日();
    }
    
    /**
     * 延期理由を取得します。
     *
     * @return 延期理由
     */
    public RString get延期理由() {
        return entity.get延期理由();
    }
    
    /**
     * 延期通知発行年月日を取得します。
     *
     * @return 延期通知発行年月日
     */
    public FlexibleDate get延期通知発行年月日() {
        return entity.get延期通知発行年月日();
    }
    
    /**
     * 延期見込期間開始年月日を取得します。
     *
     * @return 延期見込期間開始年月日
     */
    public FlexibleDate get延期見込期間開始年月日() {
        return entity.get延期見込期間開始年月日();
    }
    
    /**
     * 延期見込期間終了年月日を取得します。
     *
     * @return 延期見込期間終了年月日
     */
    public FlexibleDate get延期見込期間終了年月日() {
        return entity.get延期見込期間終了年月日();
    }
    
    /**
     * 延期通知発行回数を取得します。
     *
     * @return 延期通知発行回数
     */
    public int get延期通知発行回数() {
        return entity.get延期通知発行回数();
    }

    /**
     * 被保険者氏名カナを取得します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.get被保険者氏名カナ();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.get郵便番号();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.get住所();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.get電話番号();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return entity.get年齢();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.get性別();
    }

    /**
     * 自動割当除外者区分を取得します。
     *
     * @return 自動割当除外者区分
     */
    public Code get自動割当除外者区分() {
        return entity.get自動割当除外者区分();
    }

    /**
     * 介護認定審査会優先振分区分コードを取得します。
     *
     * @return 介護認定審査会優先振分区分コード
     */
    public Code get介護認定審査会優先振分区分コード() {
        return entity.get介護認定審査会優先振分区分コード();
    }

    /**
     * みなし２号等対象フラグを取得します。
     *
     * @return みなし２号等対象フラグ
     */
    public boolean isみなし２号等対象フラグ() {
        return entity.isみなし２号等対象フラグ();
    }
    
    /**
     * ＩＦ送付年月日を取得します。
     *
     * @return ＩＦ送付年月日
     */
    public FlexibleDate getIF送付年月日() {
        return entity.getIF送付年月日();
    }    
    
    /**
     * センター送信年月日を取得します。
     *
     * @return センター送信年月日
     */
    public FlexibleDate getセンター送信年月日() {
        return entity.getセンター送信年月日();
    }    
    
    /**
     * 認定延期通知発行しないことに対する同意有無を取得します。
     *
     * @return 認定延期通知発行しないことに対する同意有無フラグ
     */
    public boolean is認定延期通知発行しないことに対する同意有無フラグ() {
        return entity.is認定延期通知発行しないことに対する同意有無フラグ();
    }    
    
    /**
     * セ情報提供フラグを取得します。
     *
     * @return 情報提供フラグ
     */
    public boolean is情報提供フラグ() {
        return entity.is情報提供フラグ();
    }    
    
    /**
     * 認定調査依頼完了年月日を取得します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return entity.get認定調査依頼完了年月日();
    }    
    
    /**
     * 主治医意見書作成依頼完了年月日を取得します。
     *
     * @return 主治医意見書作成依頼完了年月日
     */
    public FlexibleDate get主治医意見書作成依頼完了年月日() {
        return entity.get主治医意見書作成依頼完了年月日();
    } 
    
    /**
     * 認定申請情報登録完了年月日を取得します。
     *
     * @return 認定申請情報登録完了年月日
     */
    public FlexibleDate get認定申請情報登録完了年月日() {
        return entity.get認定申請情報登録完了年月日();
    } 
    
    /**
     * 認定審査会割当完了年月日を取得します。
     *
     * @return 認定審査会割当完了年月日
     */
    public FlexibleDate get認定審査会割当完了年月日() {
        return entity.get認定審査会割当完了年月日();
    } 
    
    /**
     * 介護認定審査会割当年月日を取得します。
     *
     * @return 介護認定審査会割当年月日
     */
    public FlexibleDate get介護認定審査会割当年月日() {
        return entity.get介護認定審査会割当年月日();
    } 
    
    /**
     * 判定結果コードを取得します。
     *
     * @return 判定結果コード
     */
    public Code get判定結果コード() {
        return entity.get判定結果コード();
    } 
    
    /**
     * 入所施設名称を取得します。
     *
     * @return 入所施設名称
     */
    public AtenaMeisho get入所施設名称() {
        return entity.get入所施設名称();
    } 
}
