/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.ShujiiIkenshoTeishutsuIraishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼(手動)のビジネスクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class ShujiiIkenshoTeishutsuIraishoBusiness {

    private final ShujiiIkenshoTeishutsuIraishoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医意見書作成依頼(手動)一覧_介護保険指定医依頼兼主治医意見書提出意見書のクラス
     */
    public ShujiiIkenshoTeishutsuIraishoBusiness(ShujiiIkenshoTeishutsuIraishoEntity entity) {
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
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return entity.getAge();
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
     * 医療機関住所を取得します。
     *
     * @return 医療機関住所
     */
    public AtenaJusho get医療機関住所() {
        return entity.getIryoKikanJusho();
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
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 医療機関電話番号を取得します。
     *
     * @return 医療機関電話番号
     */
    public TelNo get医療機関電話番号() {
        return entity.getIryoKikanTelNo();
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
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 医療機関FAX番号を取得します。
     *
     * @return 医療機関FAX番号
     */
    public TelNo get医療機関FAX番号() {
        return entity.getIryoKikanFaxNo();
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
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
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
     * 主治医意見書依頼区分を取得します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.getIkenshoIraiKubun();
    }

    /**
     * 主治医意見書作成期限年月日 を取得します。
     *
     * @return 主治医意見書作成期限年月日
     */
    public FlexibleDate get主治医意見書作成期限年月日() {
        return entity.getIkenshoSakuseiKigenYMD();
    }

    /**
     * 在宅／施設区分を取得します。
     *
     * @return 在宅／施設区分
     */
    public RString get在宅施設区分() {
        return entity.getZaitakuShisetsuKubun();
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
     * 認定申請区分（申請時）コードを取得します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code get認定申請区分申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 意見書作成回数区分を取得します。
     *
     * @return 意見書作成回数区分
     */
    public Code get意見書作成回数区分() {
        return entity.getIkenshoSakuseiKaisuKubun();
    }

    /**
     * 主治医意見書記入年月日を取得します。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate get主治医意見書記入年月日() {
        return entity.getIkenshoKinyuYMD();
    }

    /**
     * 主治医意見書読取年月日を取得します。
     *
     * @return 主治医意見書読取年月日
     */
    public FlexibleDate get主治医意見書読取年月日() {
        return entity.getIkenshoReadYMD();
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
     * 保険者名を取得します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenshaName();
    }

    /**
     * 主治医意見書別途診療費を取得します。
     *
     * @return 主治医意見書別途診療費
     */
    public int get主治医意見書別途診療費() {
        return entity.getIkenshoBettoShinryohi();
    }

    /**
     * 主治医意見書報酬支払年月日を取得します。
     *
     * @return 主治医意見書報酬支払年月日
     */
    public FlexibleDate get主治医意見書報酬支払年月日() {
        return entity.getHoshuShiharaiYMD();
    }

}
