/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定処理情報です。
 *
 * @reamsid_L DBD-1530-010 lit
 */
@lombok.Getter
@lombok.Setter
public class YokaigoNinteiJoho implements Serializable {

    private final DbT4101NinteiShinseiJohoEntity 要介護認定申請情報Entity;
    private final DbV4001JukyushaDaichoEntity 受給者台帳Entity;
    private final DbT4910NinteichosaItakusakiJohoEntity 認定調査委託先情報Entity;
    private final DbT4911ShujiiIryoKikanJohoEntity 主治医医療機関情報Entity;
    private final DbT4912ShujiiJohoEntity 主治医情報Entity;
    private final DbT4913ChosainJohoEntity 調査員情報Entity;
    private DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity;
    private final DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity;

    /**
     * コンストラクタです。<br/>
     * 介護認定処理情報に使用します。
     *
     * @param 要介護認定申請情報Entity DbT4101NinteiShinseiJohoEntity
     * @param 受給者台帳Entity DbV4001JukyushaDaichoEntity
     * @param 認定調査委託先情報Entity DbT4910NinteichosaItakusakiJohoEntity
     * @param 主治医医療機関情報Entity DbT4911ShujiiIryoKikanJohoEntity
     * @param 主治医情報Entity DbT4912ShujiiJohoEntity
     * @param 調査員情報Entity DbT4913ChosainJohoEntity
     * @param 要介護認定結果情報Entity DbT4102NinteiKekkaJohoEntity
     * @param 要介護認定インターフェース情報Entity DbT4003YokaigoNinteiInterfaceEntity
     */
    public YokaigoNinteiJoho(
            DbT4101NinteiShinseiJohoEntity 要介護認定申請情報Entity,
            DbV4001JukyushaDaichoEntity 受給者台帳Entity,
            DbT4910NinteichosaItakusakiJohoEntity 認定調査委託先情報Entity,
            DbT4911ShujiiIryoKikanJohoEntity 主治医医療機関情報Entity,
            DbT4912ShujiiJohoEntity 主治医情報Entity,
            DbT4913ChosainJohoEntity 調査員情報Entity,
            DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity,
            DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity
    ) {
        this.要介護認定申請情報Entity = 要介護認定申請情報Entity;
        this.受給者台帳Entity = 受給者台帳Entity;
        this.認定調査委託先情報Entity = 認定調査委託先情報Entity;
        this.主治医医療機関情報Entity = 主治医医療機関情報Entity;
        this.主治医情報Entity = 主治医情報Entity;
        this.調査員情報Entity = 調査員情報Entity;
        this.要介護認定結果情報Entity = 要介護認定結果情報Entity;
        this.要介護認定インターフェース情報Entity = 要介護認定インターフェース情報Entity;
    }

    /**
     * コンストラクタです。<br/>
     * 介護認定処理情報に使用します。
     *
     * @param 介護認定処理情報 YokaigoNinteiJohoEntity
     */
    public YokaigoNinteiJoho(YokaigoNinteiJohoEntity 介護認定処理情報) {
        requireNonNull(介護認定処理情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定処理情報"));
        this.要介護認定申請情報Entity = 介護認定処理情報.get要介護認定申請情報Entity();
        this.受給者台帳Entity = 介護認定処理情報.get受給者台帳Entity();
        this.認定調査委託先情報Entity = 介護認定処理情報.get認定調査委託先情報Entity();
        this.主治医医療機関情報Entity = 介護認定処理情報.get主治医医療機関情報Entity();
        this.主治医情報Entity = 介護認定処理情報.get主治医情報Entity();
        this.調査員情報Entity = 介護認定処理情報.get調査員情報Entity();
        this.要介護認定結果情報Entity = 介護認定処理情報.get要介護認定結果情報Entity();
        this.要介護認定インターフェース情報Entity = 介護認定処理情報.get要介護認定インターフェース情報Entity();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShinseishoKanriNo().value();
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
     * 要支援申請の区分を返します。
     *
     * @return 要支援申請の区分
     */
    public RString get要支援申請の区分() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShienShinseiKubun();
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
     * 取下区分コードを返します。
     *
     * @return 取下区分コード
     */
    public Code get取下区分コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getTorisageKubunCode();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getHihokenshaKubunCode();
    }

    /**
     * ２号特定疾病コードを返します。
     *
     * @return ２号特定疾病コード
     */
    public Code get二号特定疾病コード() {
        return null == 要介護認定申請情報Entity ? Code.EMPTY : 要介護認定申請情報Entity.getNigoTokuteiShippeiCode();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public RString get支所コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShishoCode();
    }

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getNinteiShinseiRiyu();
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
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShujiiIryokikanCode();
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return null == 主治医医療機関情報Entity ? RString.EMPTY : 主治医医療機関情報Entity.getIryoKikanMeisho();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    public boolean get指定医フラグ() {
        return null == 要介護認定申請情報Entity ? false : 要介護認定申請情報Entity.getShiteiiFlag();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return null == 要介護認定申請情報Entity ? RString.EMPTY : 要介護認定申請情報Entity.getShujiiCode();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return null == 主治医情報Entity ? RString.EMPTY : 主治医情報Entity.getShujiiName();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return null == 要介護認定申請情報Entity ? ChosaItakusakiCode.EMPTY : 要介護認定申請情報Entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return null == 認定調査委託先情報Entity ? RString.EMPTY : 認定調査委託先情報Entity.getJigyoshaMeisho();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public ChosainCode get認定調査員コード() {
        return null == 要介護認定申請情報Entity ? ChosainCode.EMPTY : 要介護認定申請情報Entity.getNinteiChosainCode();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return null == 調査員情報Entity ? RString.EMPTY : 調査員情報Entity.getChosainShimei();
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
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return null == 受給者台帳Entity ? FlexibleDate.EMPTY : 受給者台帳Entity.getNinteiYMD();
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
     * 二次判定結果を返します。
     *
     * @return 二次判定結果
     */
    public RString getインターフェース二次判定結果() {
        return null == 要介護認定インターフェース情報Entity ? RString.EMPTY : 要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode();
    }

    /**
     * 要介護認定状態区分コードを返します。
     *
     * @return 要介護認定状態区分コード
     */
    public RString getインターフェース要介護認定状態区分コード() {
        return null == 要介護認定インターフェース情報Entity ? RString.EMPTY : 要介護認定インターフェース情報Entity.getNijiHanteiKekkaCode();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate getインターフェース認定有効期間開始年月日() {
        return null == 要介護認定インターフェース情報Entity ? FlexibleDate.EMPTY : 要介護認定インターフェース情報Entity.getNinteiYukoKikanStart();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate getインターフェース認定有効期間終了年月日() {
        return null == 要介護認定インターフェース情報Entity ? FlexibleDate.EMPTY : 要介護認定インターフェース情報Entity.getNinteiYukoKikanEnd();
    }

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public FlexibleDate getインターフェース認定年月日() {
        return null == 要介護認定インターフェース情報Entity ? FlexibleDate.EMPTY : 要介護認定インターフェース情報Entity.getNijiHanteiYMD();
    }

    /**
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    public RString getインターフェース介護認定審査会意見() {
        return null == 要介護認定インターフェース情報Entity ? RString.EMPTY : 要介護認定インターフェース情報Entity.getShinsakaiIken();
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
     * 審査会資料作成年月日を返します。
     *
     * @return 審査会資料作成年月日
     */
    public FlexibleDate get審査会資料作成年月日() {
        return null == 要介護認定インターフェース情報Entity
                ? FlexibleDate.EMPTY : 要介護認定インターフェース情報Entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 介護認定処理情報MD5値変更かどうか。
     *
     * @return 変更かどうか boolean
     */
    public boolean hasChanged() {
        return 要介護認定申請情報Entity.hasChanged()
                || 受給者台帳Entity.hasChanged()
                || 認定調査委託先情報Entity.hasChanged()
                || 主治医医療機関情報Entity.hasChanged()
                || 主治医情報Entity.hasChanged()
                || 調査員情報Entity.hasChanged()
                || 要介護認定結果情報Entity.hasChanged()
                || 要介護認定インターフェース情報Entity.hasChanged();
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link YokaigoNinteiJoho.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder YokaigoNinteiJohoBuilder
     */
    public YokaigoNinteiJohoBuilder createBuilderForEdit() {
        return new YokaigoNinteiJohoBuilder(要介護認定申請情報Entity,
                受給者台帳Entity,
                認定調査委託先情報Entity,
                主治医医療機関情報Entity,
                主治医情報Entity,
                調査員情報Entity,
                要介護認定結果情報Entity,
                要介護認定インターフェース情報Entity);
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link YokaigoNinteiJoho.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder YokaigoNinteiJohoBuilder
     */
    public YokaigoNinteiJohoBuilder createNewKekkaEntityBuilderForEdit() {
        要介護認定結果情報Entity = new DbT4102NinteiKekkaJohoEntity();
        要介護認定結果情報Entity.initializeMd5();
        要介護認定結果情報Entity.setState(EntityDataState.Added);
        return new YokaigoNinteiJohoBuilder(要介護認定申請情報Entity,
                受給者台帳Entity,
                認定調査委託先情報Entity,
                主治医医療機関情報Entity,
                主治医情報Entity,
                調査員情報Entity,
                要介護認定結果情報Entity,
                要介護認定インターフェース情報Entity);
    }
}
