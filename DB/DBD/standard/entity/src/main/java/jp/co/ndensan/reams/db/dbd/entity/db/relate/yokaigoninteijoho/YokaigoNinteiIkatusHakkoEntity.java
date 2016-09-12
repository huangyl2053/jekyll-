/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定一括発行情報帳票用Entityのクラスです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiIkatusHakkoEntity implements Cloneable, Serializable {

    private DbT4101NinteiShinseiJohoEntity 要介護認定申請情報Entity;
    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShinseishoKanriNo().value();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return null == 要介護認定申請情報Entity ? AtenaMeisho.EMPTY : 要介護認定申請情報Entity.getHihokenshaName();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getSeibetsu();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return null == 要介護認定申請情報Entity ? FlexibleDate.EMPTY : 要介護認定申請情報Entity.getSeinengappiYMD();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return null == 要介護認定申請情報Entity ? FlexibleDate.EMPTY : 要介護認定申請情報Entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分（法令）コードを返します。
     *
     * @return 認定申請区分（法令）コード
     */
    public Code get認定申請区分法令コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code get認定申請区分申請時コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getNinteiYMD();
    }

    /**
     * 要介護認定状態区分コードを返します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return null == 受給者台帳Entity ? Code.EMPTY : 受給者台帳Entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 要支援申請の区分を返します。
     *
     * @return 要支援申請の区分受給
     */
    public RString get要支援申請の区分() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShienShinseiKubun();
    }

    /**
     * 取下区分コードを返します。
     *
     * @return 取下区分コード受給
     */
    public Code get取下区分コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getTorisageKubunCode();
    }

    /**
     * 取下年月日を返します。
     *
     * @return 取下年月日受給
     */
    public FlexibleDate get取下年月日() {
        return null == 要介護認定申請情報Entity ? FlexibleDate.EMPTY : 要介護認定申請情報Entity.getTorisageYMD();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード受給
     */
    public RString get被保険者区分コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getHihokenshaKubunCode();
    }

    /**
     * ２号特定疾病コードを返します。
     *
     * @return ２号特定疾病コード受給
     */
    public Code get二号特定疾病コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getNigoTokuteiShippeiCode();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード受給
     */
    public RString get支所コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShishoCode();
    }

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由受給
     */
    public RString get認定申請理由() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getNinteiShinseiRiyu();
    }

    /**
     * 申請サービス削除の理由を返します。
     *
     * @return 申請サービス削除の理由受給
     */
    public RString get申請サービス削除の理由() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShinseiServiceDeleteRiyu();
    }

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード受給
     */
    public Code get前回要介護状態区分コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getZenYokaigoKubunCode();
    }

    /**
     * 前回認定年月日を返します。
     *
     * @return 前回認定年月日受給
     */
    public FlexibleDate get前回認定年月日() {
        return null == 要介護認定申請情報Entity ? FlexibleDate.EMPTY : 要介護認定申請情報Entity.getZenkaiNinteiYMD();
    }

    /**
     * 前回認定有効期間（開始）を返します。
     *
     * @return 前回認定有効期間（開始）受給
     */
    public FlexibleDate get前回認定有効期間開始() {
        return null == 要介護認定申請情報Entity ? FlexibleDate.EMPTY : 要介護認定申請情報Entity.getZenkaiYukoKikanStart();
    }

    /**
     * 前回認定有効期間（終了）を返します。
     *
     * @return 前回認定有効期間（終了）受給
     */
    public FlexibleDate get前回認定有効期間終了() {
        return null == 要介護認定申請情報Entity ? FlexibleDate.EMPTY : 要介護認定申請情報Entity.getZenkaiYukoKikanEnd();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード受給
     */
    public RString get主治医医療機関コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShujiiIryokikanCode();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ受給
     */
    public boolean get指定医フラグ() {
        return null == 要介護認定申請情報Entity ? false : 要介護認定申請情報Entity.getShiteiiFlag();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード受給
     */
    public RString get主治医コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShujiiCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード受給
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return null == 要介護認定申請情報Entity ? ChosaItakusakiCode.EMPTY : 要介護認定申請情報Entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード受給
     */
    public ChosainCode get認定調査員コード() {
        return null == 要介護認定申請情報Entity ? ChosainCode.EMPTY : 要介護認定申請情報Entity.getNinteiChosainCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return null == 受給者台帳Entity ? RString.EMPTY : 受給者台帳Entity.getRirekiNo();
    }

    /**
     * 受給申請事由を返します。
     *
     * @return 受給申請事由
     */
    public RString get受給申請事由() {
        return null == 受給者台帳Entity ? RString.EMPTY : 受給者台帳Entity.getShinseiRiyu();
    }

    /**
     * 申請状況区分を返します。
     *
     * @return 申請状況区分
     */
    public RString get申請状況区分() {
        return null == 受給者台帳Entity ? RString.EMPTY : 受給者台帳Entity.getShinseiJokyoKubun();
    }

    /**
     * 旧措置者フラグを返します。
     *
     * @return 旧措置者フラグ
     */
    public boolean get旧措置者フラグ() {
        return null == 受給者台帳Entity ? false : 受給者台帳Entity.getKyuSochishaFlag();
    }

    /**
     * 資格取得前申請フラグを返します。
     *
     * @return 資格取得前申請フラグ
     */
    public boolean get資格取得前申請フラグ() {
        return null == 受給者台帳Entity ? false : 受給者台帳Entity.getShikakuShutokuMaeShinseiFlag();
    }

    /**
     * 喪失年月日を返します。
     *
     * @return 喪失年月日
     */
    public FlexibleDate get喪失年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getSoshitsuYMD();
    }

    /**
     * 指定サービス種類01を返します。
     *
     * @return 指定サービス種類01
     */
    public ServiceShuruiCode get指定サービス種類01() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui01();
    }

    /**
     * 指定サービス種類02を返します。
     *
     * @return 指定サービス種類02
     */
    public ServiceShuruiCode get指定サービス種類02() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui02();
    }

    /**
     * 指定サービス種類03を返します。
     *
     * @return 指定サービス種類03
     */
    public ServiceShuruiCode get指定サービス種類03() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui03();
    }

    /**
     * 指定サービス種類04を返します。
     *
     * @return 指定サービス種類04
     */
    public ServiceShuruiCode get指定サービス種類04() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui04();
    }

    /**
     * 指定サービス種類05を返します。
     *
     * @return 指定サービス種類05
     */
    public ServiceShuruiCode get指定サービス種類05() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui05();
    }

    /**
     * 指定サービス種類06を返します。
     *
     * @return 指定サービス種類06
     */
    public ServiceShuruiCode get指定サービス種類06() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui06();
    }

    /**
     * 指定サービス種類07を返します。
     *
     * @return 指定サービス種類07
     */
    public ServiceShuruiCode get指定サービス種類07() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui07();
    }

    /**
     * 指定サービス種類08を返します。
     *
     * @return 指定サービス種類08
     */
    public ServiceShuruiCode get指定サービス種類08() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui08();
    }

    /**
     * 指定サービス種類09を返します。
     *
     * @return 指定サービス種類09
     */
    public ServiceShuruiCode get指定サービス種類09() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui09();
    }

    /**
     * 指定サービス種類10を返します。
     *
     * @return 指定サービス種類10
     */
    public ServiceShuruiCode get指定サービス種類10() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui10();
    }

    /**
     * 指定サービス種類11を返します。
     *
     * @return 指定サービス種類11
     */
    public ServiceShuruiCode get指定サービス種類11() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui11();
    }

    /**
     * 指定サービス種類12を返します。
     *
     * @return 指定サービス種類12
     */
    public ServiceShuruiCode get指定サービス種類12() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui12();
    }

    /**
     * 指定サービス種類13を返します。
     *
     * @return 指定サービス種類13
     */
    public ServiceShuruiCode get指定サービス種類13() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui13();
    }

    /**
     * 指定サービス種類14を返します。
     *
     * @return 指定サービス種類14
     */
    public ServiceShuruiCode get指定サービス種類14() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui14();
    }

    /**
     * 指定サービス種類15を返します。
     *
     * @return 指定サービス種類15
     */
    public ServiceShuruiCode get指定サービス種類15() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui15();
    }

    /**
     * 指定サービス種類16を返します。
     *
     * @return 指定サービス種類16
     */
    public ServiceShuruiCode get指定サービス種類16() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui16();
    }

    /**
     * 指定サービス種類17を返します。
     *
     * @return 指定サービス種類17
     */
    public ServiceShuruiCode get指定サービス種類17() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui17();
    }

    /**
     * 指定サービス種類18を返します。
     *
     * @return 指定サービス種類18
     */
    public ServiceShuruiCode get指定サービス種類18() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui18();
    }

    /**
     * 指定サービス種類19を返します。
     *
     * @return 指定サービス種類19
     */
    public ServiceShuruiCode get指定サービス種類19() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui19();
    }

    /**
     * 指定サービス種類20を返します。
     *
     * @return 指定サービス種類20
     */
    public ServiceShuruiCode get指定サービス種類20() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui20();
    }

    /**
     * 指定サービス種類21を返します。
     *
     * @return 指定サービス種類21
     */
    public ServiceShuruiCode get指定サービス種類21() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui21();
    }

    /**
     * 指定サービス種類22を返します。
     *
     * @return 指定サービス種類22
     */
    public ServiceShuruiCode get指定サービス種類22() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui22();
    }

    /**
     * 指定サービス種類23を返します。
     *
     * @return 指定サービス種類23
     */
    public ServiceShuruiCode get指定サービス種類23() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui23();
    }

    /**
     * 指定サービス種類24を返します。
     *
     * @return 指定サービス種類24
     */
    public ServiceShuruiCode get指定サービス種類24() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui24();
    }

    /**
     * 指定サービス種類25を返します。
     *
     * @return 指定サービス種類25
     */
    public ServiceShuruiCode get指定サービス種類25() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui25();
    }

    /**
     * 指定サービス種類26を返します。
     *
     * @return 指定サービス種類26
     */
    public ServiceShuruiCode get指定サービス種類26() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui26();
    }

    /**
     * 指定サービス種類27を返します。
     *
     * @return 指定サービス種類27
     */
    public ServiceShuruiCode get指定サービス種類27() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui27();
    }

    /**
     * 指定サービス種類28を返します。
     *
     * @return 指定サービス種類28
     */
    public ServiceShuruiCode get指定サービス種類28() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui28();
    }

    /**
     * 指定サービス種類29を返します。
     *
     * @return 指定サービス種類29
     */
    public ServiceShuruiCode get指定サービス種類29() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui29();
    }

    /**
     * 指定サービス種類30を返します。
     *
     * @return 指定サービス種類30
     */
    public ServiceShuruiCode get指定サービス種類30() {
        return null == 受給者台帳Entity ? ServiceShuruiCode.EMPTY : 受給者台帳Entity.getShiteiServiceShurui30();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public Code getデータ区分() {
        return null == 受給者台帳Entity ? Code.EMPTY : 受給者台帳Entity.getDataKubun();
    }

    /**
     * 異動理由を返します。
     *
     * @return 異動理由
     */
    public RString get異動理由() {
        return null == 受給者台帳Entity ? RString.EMPTY : 受給者台帳Entity.getIdoRiyu();
    }

    /**
     * 当初認定有効開始年月日を返します。
     *
     * @return 当初認定有効開始年月日
     */
    public FlexibleDate get当初認定有効開始年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getToshoNinteiYukoKaishiYMD();
    }

    /**
     * 当初認定有効終了年月日を返します。
     *
     * @return 当初認定有効終了年月日
     */
    public FlexibleDate get当初認定有効終了年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getToshoNinteiYukoShuryoYMD();
    }

    /**
     * 受給資格証明書発行年月日１を返します。
     *
     * @return 受給資格証明書発行年月日１
     */
    public FlexibleDate get受給資格証明書発行年月日１() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getJukyuShikakuShomeishoHakkoYMD1();
    }

    /**
     * 受給資格証明書発行年月日２を返します。
     *
     * @return 受給資格証明書発行年月日２
     */
    public FlexibleDate get受給資格証明書発行年月日２() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getJukyuShikakuShomeishoHakkoYMD2();
    }

    /**
     * 削除事由コードを返します。
     *
     * @return 削除事由コード
     */
    public Code get削除事由コード() {
        return null == 受給者台帳Entity ? Code.EMPTY : 受給者台帳Entity.getSakujoJiyuCode();
    }

    /**
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        return null == 要介護認定結果情報Entity ? RString.EMPTY : 要介護認定結果情報Entity.getNinteishinsakaiIkenShurui();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定要介護状態区分コード() {
        return null == 要介護認定結果情報Entity ? Code.EMPTY : 要介護認定結果情報Entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効開始年月日を返します。
     *
     * @return 二次判定認定有効開始年月日
     */
    public FlexibleDate get二次判定認定有効開始年月日() {
        return null == 要介護認定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定結果情報Entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日
     */
    public FlexibleDate get二次判定認定有効終了年月日() {
        return null == 要介護認定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定結果情報Entity.getNijiHanteiNinteiYukoShuryoYMD();
    }

    /**
     * 二次判定日を返します。
     *
     * @return 二次判定日
     */
    public FlexibleDate get二次判定日() {
        return null == 要介護認定結果情報Entity ? FlexibleDate.EMPTY : 要介護認定結果情報Entity.getNijiHanteiYMD();
    }

    /**
     * 審査会メモを返します。
     *
     * @return 審査会メモ
     */
    public RString get審査会メモ() {
        return null == 要介護認定結果情報Entity ? RString.EMPTY : 要介護認定結果情報Entity.getShinsakaiMemo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * みなし２号等対象フラグを返します。
     *
     * @return みなし２号等対象フラグ
     */
    public Boolean getみなし２号等対象フラグ() {
        return null == 要介護認定申請情報Entity ? null : 要介護認定申請情報Entity.getMinashiNigoEtcTaishoFlag();
    }

    /**
     * 審査会依頼年月日を返します。
     *
     * @return 審査会依頼年月日
     */
    public FlexibleDate get審査会依頼年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getShinsakaiIraiYMD();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return null == 受給者台帳Entity ? ShikibetsuCode.EMPTY : 受給者台帳Entity.getShikibetsuCode();
    }

}
