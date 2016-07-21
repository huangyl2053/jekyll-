/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudouEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼(手動)のビジネスクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoirairirekiichiranShudou {

    private final IkenshoirairirekiichiranShudouEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医意見書作成依頼(手動)一覧情報
     */
    public IkenshoirairirekiichiranShudou(IkenshoirairirekiichiranShudouEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 主治医意見書作成依頼履歴番号を取得します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public RString get主治医意見書作成依頼履歴番号() {
        return entity.getIkenshoIraiRirekiNo();
    }

    /**
     * 主治医意見書依頼区分を取得します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.getIkenshoIraiKubun();
    }

    /**
     * 医師区分コードを取得します。
     *
     * @return 医師区分コード
     */
    public Code get医師区分コード() {
        return entity.getIshiKubunCode();
    }

    /**
     * 主治医意見書作成依頼年月日を取得します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 被保険者氏名カナを取得します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 認定申請区分申請時コードを取得します。
     *
     * @return 認定申請区分申請時コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 主治医意見書作成期限年月日を取得します。
     *
     * @return 主治医意見書作成期限年月日
     */
    public FlexibleDate get主治医意見書作成期限年月日() {
        return entity.getIkenshoSakuseiKigenYMD();
    }

    /**
     * 医療機関郵便番号を取得します。
     *
     * @return 医療機関郵便番号
     */
    public YubinNo get医療機関郵便番号() {
        return entity.getIryoKikanYubinNo();
    }

    /**
     * 医療機関住所を取得します。
     *
     * @return 医療機関住所
     */
    public AtenaJusho get医療機関住所() {
        return entity.getIryoKikanJusho();
    }

    /**
     * 代表者名を取得します。
     *
     * @return 代表者名
     */
    public RString get代表者名() {
        return entity.getDaihyoshaName();
    }

    /**
     * 依頼書出力年月日を取得します。
     *
     * @return 依頼書出力年月日
     */
    public FlexibleDate get依頼書出力年月日() {
        return entity.getIraishoShutsuryokuYMD();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }
}
