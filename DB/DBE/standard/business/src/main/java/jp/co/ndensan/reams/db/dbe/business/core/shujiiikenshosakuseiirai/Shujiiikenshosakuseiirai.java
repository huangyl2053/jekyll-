/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiikenshosakuseiiraiRelateEntity;
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
 * 主治医意見書作成依頼Businessです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class Shujiiikenshosakuseiirai {

    private final ShujiiikenshosakuseiiraiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医意見書作成依頼Entity
     */
    public Shujiiikenshosakuseiirai(ShujiiikenshosakuseiiraiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * Temp_申請書管理番号を取得します。
     *
     * @return Temp_申請書管理番号
     */
    public ShinseishoKanriNo getTemp_申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * Temp_保険者番号を取得します。
     *
     * @return Temp_保険者番号
     */
    public RString getTemp_保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * Temp_厚労省IF識別コードを取得します。
     *
     * @return Temp_厚労省IF識別コード
     */
    public Code getTemp_厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * Temp_被保険者氏名を取得します。
     *
     * @return Temp_被保険者氏名
     */
    public AtenaMeisho getTemp_被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * Temp_被保険者氏名カナを取得します。
     *
     * @return Temp_被保険者氏名カナ
     */
    public AtenaKanaMeisho getTemp_被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * Temp_生年月日を取得します。
     *
     * @return Temp_生年月日
     */
    public FlexibleDate getTemp_生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * Temp_年齢を取得します。
     *
     * @return Temp_年齢
     */
    public int getTemp_年齢() {
        return entity.getAge();
    }

    /**
     * Temp_性別を取得します。
     *
     * @return Temp_性別
     */
    public Code getTemp_性別() {
        return entity.getSeibetsu();
    }

    /**
     * Temp_認定申請日を取得します。
     *
     * @return Temp_認定申請日
     */
    public FlexibleDate getTemp_認定申請日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * Temp_住所を取得します。
     *
     * @return Temp_住所
     */
    public AtenaJusho getTemp_住所() {
        return entity.getJusho();
    }

    /**
     * Temp_郵便番号を取得します。
     *
     * @return Temp_郵便番号
     */
    public YubinNo getTemp_郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * Temp_電話番号を取得します。
     *
     * @return Temp_電話番号
     */
    public TelNo getTemp_電話番号() {
        return entity.getTelNo();
    }

    /**
     * Temp_主治医医療機関コードを取得します。
     *
     * @return Temp_主治医医療機関コード
     */
    public RString getTemp_主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * Temp_主治医コードを取得します。
     *
     * @return Temp_主治医コード
     */
    public RString getTemp_主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * Temp_保険者名称を取得します。
     *
     * @return Temp_保険者名称
     */
    public RString getTemp_保険者名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * Temp_市町村コードを取得します。
     *
     * @return Temp_市町村コード
     */
    public LasdecCode getTemp_市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * Temp_主治医医療機関を取得します。
     *
     * @return Temp_主治医医療機関
     */
    public RString getTemp_主治医医療機関() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * Temp_医療機関所在地を取得します。
     *
     * @return Temp_医療機関所在地
     */
    public RString getTemp_医療機関所在地() {
        return entity.getIryoKikanJusho();
    }

    /**
     * Temp_医療機関電話番号を取得します。
     *
     * @return Temp_医療機関電話番号
     */
    public TelNo getTemp_医療機関電話番号() {
        return entity.getIryoKikanTelNo();
    }

    /**
     * 医療機関所FAXを取得します。
     *
     * @return 医療機関所FAX
     */
    public RString getTemp_医療機関所FAX() {
        return entity.getIryoKikanFaxNo();
    }

    /**
     * Temp_主治医を取得します。
     *
     * @return Temp_主治医
     */
    public AtenaMeisho getTemp_主治医() {
        return entity.getShujiiName();
    }

    /**
     * Temp_主治医意見書作成依頼日を取得します。
     *
     * @return Temp_主治医意見書作成依頼日
     */
    public FlexibleDate getTemp_主治医意見書作成依頼日() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * Temp_依頼書出力年月日を取得します。
     *
     * @return Temp_依頼書出力年月日
     */
    public FlexibleDate getTemp_依頼書出力年月日() {
        return entity.getIraishoShutsuryokuYMD();
    }

    /**
     * Temp_意見書出力年月日を取得します。
     *
     * @return Temp_意見書出力年月日
     */
    public FlexibleDate getTemp_意見書出力年月日() {
        return entity.getIkenshoShutsuryokuYMD();
    }

    /**
     * Temp_請求書出力年月日を取得します。
     *
     * @return Temp_請求書出力年月日
     */
    public FlexibleDate getTemp_請求書出力年月日() {
        return entity.getSeikyushoShutsuryokuYMD();
    }

    /**
     * Temp_主治医意見書依頼区分を取得します。
     *
     * @return Temp_主治医意見書依頼区分
     */
    public RString getTemp_主治医意見書依頼区分() {
        return entity.getIkenshoIraiKubun();
    }

    /**
     * Temp_前回主治医医療機関を取得します。
     *
     * @return Temp_前回主治医医療機関
     */
    public RString getTemp_前回主治医医療機関() {
        return entity.getPreIryoKikanMeisho();
    }

    /**
     * Temp_前回主治医を取得します。
     *
     * @return Temp_前回主治医
     */
    public AtenaMeisho getTemp_前回主治医() {
        return entity.getPreShujiiName();
    }

    /**
     * Temp_申請区分を取得します。
     *
     * @return Temp_申請区分
     */
    public Code getTemp_申請区分() {
        return entity.getShinseiShinseijiKubunCode();
    }

    /**
     * Temp_最大履歴番号を取得します。
     *
     * @return Temp_最大履歴番号
     */
    public int getTemp_最大履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * Temp_前回最大履歴番号を取得します。
     *
     * @return Temp_前回最大履歴番号
     */
    public int getTemp_前回最大履歴番号() {
        return entity.getPreRirekiNo();
    }

    /**
     * Temp_施設利用フラグを取得します。
     *
     * @return Temp_施設利用フラグ
     */
    public boolean isTemp_施設利用フラグ() {
        return entity.isShisetsuNyushoFlag();
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
     * Temp_医療機関郵便番号を取得します。
     *
     * @return Temp_医療機関郵便番号
     */
    public YubinNo getTemp_医療機関郵便番号() {
        return entity.getIryoKikanYubinNo();
    }

    /**
     * Temp_代表者名を取得します。
     *
     * @return Temp_代表者名
     */
    public RString getTemp_代表者名() {
        return entity.getDaihyoshaName();
    }
}
