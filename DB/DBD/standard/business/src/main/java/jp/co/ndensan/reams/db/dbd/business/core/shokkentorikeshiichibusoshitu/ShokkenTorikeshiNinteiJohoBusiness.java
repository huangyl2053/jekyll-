/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shokkentorikeshiichibusoshitu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「職権修正/職権取消(一部)/認定結果入力(サ変・区変)」画面の前回情報ビジネスクラスです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
public class ShokkenTorikeshiNinteiJohoBusiness implements Serializable {

    private final ShokkenTorikeshiNinteiJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 前回情報Entity
     */
    public ShokkenTorikeshiNinteiJohoBusiness(ShokkenTorikeshiNinteiJohoEntity entity) {
        this.entity = entity;
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
     * 要介護申請・要支援申請の区分を取得します。
     *
     * @return 要介護申請・要支援申請の区分
     */
    public RString get要介護申請要支援申請の区分() {
        return entity.getShienShinseiKubun();
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
     * 認定申請区分（法令）コードを取得します。
     *
     * @return 認定申請区分（法令）コード
     */
    public RString get認定申請区分法令コード() {
        return entity.getNinteiShinseiHoreiKubunCode();
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
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public Code get被保険者区分コード() {
        return entity.getHihokenshaKubunCode();
    }

    /**
     * 二号特定疾病コードを取得します。
     *
     * @return 二号特定疾病コード
     */
    public Code get二号特定疾病コード() {
        return entity.getNigoTokuteiShippeiCode();
    }

    /**
     * 支所コードを取得します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * 認定申請理由を取得します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return entity.getNinteiShinseiRiyu();
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
     * 指定医フラグを取得します。
     *
     * @return 指定医フラグ
     */
    public boolean get指定医フラグ() {
        return entity.isShiteiiFlag();
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
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public ChosainCode get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 受給申請事由を取得します。
     *
     * @return 受給申請事由
     */
    public Code get受給申請事由() {
        return entity.getJukyuShinseiJiyu();
    }

    /**
     * 申請状況区分を取得します。
     *
     * @return 申請状況区分
     */
    public RString get申請状況区分() {
        return entity.getShinseiJokyoKubun();
    }

    /**
     * 旧措置者フラグを取得します。
     *
     * @return 旧措置者フラグ
     */
    public boolean get旧措置者フラグ() {
        return entity.isKyuSochishaFlag();
    }

    /**
     * 資格取得前申請フラグを取得します。
     *
     * @return 資格取得前申請フラグ
     */
    public boolean get資格取得前申請フラグ() {
        return entity.isShikakuShutokuMaeShinseiFlag();
    }

    /**
     * 喪失年月日を取得します。
     *
     * @return 喪失年月日
     */
    public FlexibleDate get喪失年月日() {
        return entity.getSoshitsuYMD();
    }

    /**
     * 要介護認定状態区分コードを取得します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定有効期間開始年月日を取得します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を取得します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 認定年月日を取得します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return entity.getNinteiYMD();
    }

    /**
     * 指定サービス種類01を取得します。
     *
     * @return 指定サービス種類01
     */
    public ServiceShuruiCode get指定サービス種類01() {
        return entity.getShiteiServiceShurui01();
    }

    /**
     * 指定サービス種類02を取得します。
     *
     * @return 指定サービス種類02
     */
    public ServiceShuruiCode get指定サービス種類02() {
        return entity.getShiteiServiceShurui02();
    }

    /**
     * 指定サービス種類03を取得します。
     *
     * @return 指定サービス種類03
     */
    public ServiceShuruiCode get指定サービス種類03() {
        return entity.getShiteiServiceShurui03();
    }

    /**
     * 指定サービス種類04を取得します。
     *
     * @return 指定サービス種類04
     */
    public ServiceShuruiCode get指定サービス種類04() {
        return entity.getShiteiServiceShurui04();
    }

    /**
     * 指定サービス種類05を取得します。
     *
     * @return 指定サービス種類05
     */
    public ServiceShuruiCode get指定サービス種類05() {
        return entity.getShiteiServiceShurui05();
    }

    /**
     * 指定サービス種類06を取得します。
     *
     * @return 指定サービス種類06
     */
    public ServiceShuruiCode get指定サービス種類06() {
        return entity.getShiteiServiceShurui06();
    }

    /**
     * 指定サービス種類07を取得します。
     *
     * @return 指定サービス種類07
     */
    public ServiceShuruiCode get指定サービス種類07() {
        return entity.getShiteiServiceShurui07();
    }

    /**
     * 指定サービス種類08を取得します。
     *
     * @return 指定サービス種類08
     */
    public ServiceShuruiCode get指定サービス種類08() {
        return entity.getShiteiServiceShurui08();
    }

    /**
     * 指定サービス種類09を取得します。
     *
     * @return 指定サービス種類09
     */
    public ServiceShuruiCode get指定サービス種類09() {
        return entity.getShiteiServiceShurui09();
    }

    /**
     * 指定サービス種類10を取得します。
     *
     * @return 指定サービス種類10
     */
    public ServiceShuruiCode get指定サービス種類10() {
        return entity.getShiteiServiceShurui10();
    }

    /**
     * 指定サービス種類11を取得します。
     *
     * @return 指定サービス種類11
     */
    public ServiceShuruiCode get指定サービス種類11() {
        return entity.getShiteiServiceShurui11();
    }

    /**
     * 指定サービス種類12を取得します。
     *
     * @return 指定サービス種類12
     */
    public ServiceShuruiCode get指定サービス種類12() {
        return entity.getShiteiServiceShurui12();
    }

    /**
     * 指定サービス種類13を取得します。
     *
     * @return 指定サービス種類13
     */
    public ServiceShuruiCode get指定サービス種類13() {
        return entity.getShiteiServiceShurui13();
    }

    /**
     * 指定サービス種類14を取得します。
     *
     * @return 指定サービス種類14
     */
    public ServiceShuruiCode get指定サービス種類14() {
        return entity.getShiteiServiceShurui14();
    }

    /**
     * 指定サービス種類15を取得します。
     *
     * @return 指定サービス種類15
     */
    public ServiceShuruiCode get指定サービス種類15() {
        return entity.getShiteiServiceShurui15();
    }

    /**
     * 指定サービス種類16を取得します。
     *
     * @return 指定サービス種類16
     */
    public ServiceShuruiCode get指定サービス種類16() {
        return entity.getShiteiServiceShurui16();
    }

    /**
     * 指定サービス種類17を取得します。
     *
     * @return 指定サービス種類17
     */
    public ServiceShuruiCode get指定サービス種類17() {
        return entity.getShiteiServiceShurui17();
    }

    /**
     * 指定サービス種類18を取得します。
     *
     * @return 指定サービス種類18
     */
    public ServiceShuruiCode get指定サービス種類18() {
        return entity.getShiteiServiceShurui18();
    }

    /**
     * 指定サービス種類19を取得します。
     *
     * @return 指定サービス種類19
     */
    public ServiceShuruiCode get指定サービス種類19() {
        return entity.getShiteiServiceShurui19();
    }

    /**
     * 指定サービス種類20を取得します。
     *
     * @return 指定サービス種類20
     */
    public ServiceShuruiCode get指定サービス種類20() {
        return entity.getShiteiServiceShurui20();
    }

    /**
     * 指定サービス種類21を取得します。
     *
     * @return 指定サービス種類21
     */
    public ServiceShuruiCode get指定サービス種類21() {
        return entity.getShiteiServiceShurui21();
    }

    /**
     * 指定サービス種類22を取得します。
     *
     * @return 指定サービス種類22
     */
    public ServiceShuruiCode get指定サービス種類22() {
        return entity.getShiteiServiceShurui22();
    }

    /**
     * 指定サービス種類23を取得します。
     *
     * @return 指定サービス種類23
     */
    public ServiceShuruiCode get指定サービス種類23() {
        return entity.getShiteiServiceShurui23();
    }

    /**
     * 指定サービス種類24を取得します。
     *
     * @return 指定サービス種類24
     */
    public ServiceShuruiCode get指定サービス種類24() {
        return entity.getShiteiServiceShurui24();
    }

    /**
     * 指定サービス種類25を取得します。
     *
     * @return 指定サービス種類25
     */
    public ServiceShuruiCode get指定サービス種類25() {
        return entity.getShiteiServiceShurui25();
    }

    /**
     * 指定サービス種類26を取得します。
     *
     * @return 指定サービス種類26
     */
    public ServiceShuruiCode get指定サービス種類26() {
        return entity.getShiteiServiceShurui26();
    }

    /**
     * 指定サービス種類27を取得します。
     *
     * @return 指定サービス種類27
     */
    public ServiceShuruiCode get指定サービス種類27() {
        return entity.getShiteiServiceShurui27();
    }

    /**
     * 指定サービス種類28を取得します。
     *
     * @return 指定サービス種類28
     */
    public ServiceShuruiCode get指定サービス種類28() {
        return entity.getShiteiServiceShurui28();
    }

    /**
     * 指定サービス種類29を取得します。
     *
     * @return 指定サービス種類29
     */
    public ServiceShuruiCode get指定サービス種類29() {
        return entity.getShiteiServiceShurui29();
    }

    /**
     * 指定サービス種類30を取得します。
     *
     * @return 指定サービス種類30
     */
    public ServiceShuruiCode get指定サービス種類30() {
        return entity.getShiteiServiceShurui30();
    }

    /**
     * 介護認定審査会意見を取得します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        return entity.getShinsakaiIken();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }
}
