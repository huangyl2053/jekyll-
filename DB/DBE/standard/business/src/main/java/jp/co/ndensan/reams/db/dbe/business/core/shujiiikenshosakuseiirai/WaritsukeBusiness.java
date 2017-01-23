/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.WaritsukeEntity;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3213
 */
public class WaritsukeBusiness {

    private final WaritsukeEntity entity;

    /**
     * 割付済み申請者一覧を返します。
     *
     * @param entity WaritsukeEntity
     */
    public WaritsukeBusiness(WaritsukeEntity entity) {
        this.entity = entity;
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho getHihokenshaName() {
        return entity.getHihokenshaName();
    }

    /**
     * 被保険者性別コードを返します。
     *
     * @return 被保険者性別コード
     */
    public Code getSeibetsu() {
        return entity.getSeibetsu();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate getNinteiShinseiYMD() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code getNinteiShinseiKubunCode() {
        return entity.getNinteiShinseiKubunCode();
    }

    /**
     * 被保険者地区コードを返します。
     *
     * @return 被保険者地区コード
     */
    public ChikuCode getChikuCode() {
        return entity.getChikuCode();
    }

    /**
     * 調査区分コードを返します。
     *
     * @return 調査区分コード
     */
    public Code getIkenshoIraiKubun() {
        return entity.getIkenshoIraiKubun();
    }

    /**
     * 被保険者住所を返します。
     *
     * @return 被保険者住所
     */
    public AtenaJusho getJusho() {
        return entity.getJusho();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho getHihokenshaKana() {
        return entity.getHihokenshaKana();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 住所郵便番号を返します。
     *
     * @return 住所郵便番号
     */
    public YubinNo getYubinNo() {
        return entity.getYubinNo();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return entity.getTelNo();
    }

    /**
     * 要介護認定（更新）申請日を返します。
     *
     * @return 要介護認定（更新）申請日
     */
    public FlexibleDate getNinteiShinseiYMDKoShin() {
        return entity.getNinteiShinseiYMDKoShin();
    }

    /**
     * 前回認定年月日を返します。
     *
     * @return 前回認定年月日
     */
    public FlexibleDate getZenkaiNinteiYMD() {
        return entity.getZenkaiNinteiYMD();
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    public Code getZenYokaigoKubunCode() {
        return entity.getZenYokaigoKubunCode();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public int getAge() {
        return entity.getAge();
    }

    /**
     * 主治医意見書作成依頼年月日を返します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate getIkenshoSakuseiIraiYMD() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 主治医意見書作成期限年月日を返します。
     *
     * @return 主治医意見書作成期限年月日
     */
    public FlexibleDate getIkenshoSakuseiKigenYMD() {
        return entity.getIkenshoSakuseiKigenYMD();
    }

    /**
     * 依頼書出力年月日を返します。
     *
     * @return 依頼書出力年月日
     */
    public FlexibleDate getIraishoShutsuryokuYMD() {
        return entity.getIraishoShutsuryokuYMD();
    }

    /**
     * 主治医意見書出力年月日を返します。
     *
     * @return 主治医意見書出力年月日
     */
    public FlexibleDate getIkenshoShutsuryokuYMD() {
        return entity.getIkenshoShutsuryokuYMD();
    }

    /**
     * 請求書出力年月日を返します。
     *
     * @return 請求書出力年月日
     */
    public FlexibleDate getSeikyushoShutsuryokuYMD() {
        return entity.getSeikyushoShutsuryokuYMD();
    }

    /**
     * 主治医医療機関を返します。
     *
     * @return 主治医医療機関
     */
    public RString getIryoKikanMeisho() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医を返します。
     *
     * @return 主治医
     */
    public AtenaMeisho getShujiiName() {
        return entity.getShujiiName();
    }

    /**
     * 前回主治医医療機関を返します。
     *
     * @return 前回主治医医療機関
     */
    public RString getTemp_iryoKikanMeisho() {
        return entity.getTemp_iryoKikanMeisho();
    }

    /**
     * 前回主治医を返します。
     *
     * @return 前回主治医
     */
    public AtenaMeisho getTemp_shujiiName() {
        return entity.getTemp_shujiiName();
    }

    /**
     * 前回認定調査委託先を返します。
     *
     * @return 前回認定調査委託先
     */
    public RString getTemp_jigyoshaMeisho() {
        return entity.getTemp_jigyoshaMeisho();
    }

    /**
     * 前回調査員氏名を返します。
     *
     * @return 前回調査員氏名
     */
    public RString getTemp_chosainShimei() {
        return entity.getTemp_chosainShimei();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString getShinseishoKanriNo() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString getHokenshaNo() {
        return entity.getHokenshaNo();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public RString getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 主治医意見書依頼履歴番号を返します。
     *
     * @return 主治医意見書依頼履歴番号
     */
    public int getIkenshoIraiRirekiNo() {
        return entity.getIkenshoIraiRirekiNo();
    }

    /**
     * 主治医意見書登録完了年月日を返します。
     *
     * @return 主治医意見書登録完了年月日
     */
    public FlexibleDate getShujiiIkenshoTorokuKanryoYMD() {
        return entity.getNinteiKanryoJohoEntity().getIkenshoTorokuKanryoYMD();
    }

    /**
     * 認定完了情報を返します。
     *
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho getNinteiKanryoJohoEntity() {
        return new NinteiKanryoJoho(entity.getNinteiKanryoJohoEntity());
    }

    /**
     * 主治医意見書作成依頼情報を返します。
     *
     * @return ShujiiIkenshoIraiJoho
     */
    public ShujiiIkenshoIraiJoho getShujiiIkenshoIraiJoho() {
        return (entity.getShujiiIkenshoIraiJohoEntity() != null)
                ? new ShujiiIkenshoIraiJoho(entity.getShujiiIkenshoIraiJohoEntity())
                : null;
    }
}
