/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.jukyushokai;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai.JukyuShokaiShinseiNinteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請認定情報を定義するクラスです。
 *
 * @reamsid_L DBD-3560-011 xuyue
 */
public class JukyuShokaiShinseiNinteiJoho {

    private final JukyuShokaiShinseiNinteiEntity 申請認定情報Entity;

    /**
     * コンストラクタです。
     *
     * @param 申請認定情報Entity 申請認定情報Entity
     */
    public JukyuShokaiShinseiNinteiJoho(JukyuShokaiShinseiNinteiEntity 申請認定情報Entity) {
        this.申請認定情報Entity = 申請認定情報Entity;
    }

    /**
     * 受給者台帳_受給申請事由を取得します。
     *
     * @return 受給者台帳_受給申請事由
     */
    public Code get受給者台帳_受給申請事由() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_jukyuShinseiJiyu();
    }

    /**
     * 受給者台帳_受給申請年月日を取得します。
     *
     * @return 受給者台帳_受給申請年月日
     */
    public FlexibleDate get受給者台帳_受給申請年月日() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_jukyuShinseiYMD();
    }

    /**
     * 受給者台帳_申請書区分を取得します。
     *
     * @return 受給者台帳_申請書区分
     */
    public Code get受給者台帳_申請書区分() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shinseishoKubun();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return 申請認定情報Entity.get主治医氏名();
    }

    /**
     * 指定医フラグを取得します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return 申請認定情報Entity.is指定医フラグ();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return 申請認定情報Entity.get医療機関名称();
    }

    /**
     * 要介護認定申請情報_厚労省IF識別コードを取得します。
     *
     * @return 要介護認定申請情報_厚労省IF識別コード
     */
    public Code get要介護認定申請情報_厚労省IF識別コード() {
        return 申請認定情報Entity.getDbT4101NinteiShinseiJoho_koroshoIfShikibetsuCode();
    }

    /**
     * 受給者台帳_要介護認定状態区分コードを取得します。
     *
     * @return 受給者台帳_要介護認定状態区分コード
     */
    public Code get受給者台帳_要介護認定状態区分コード() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_yokaigoJotaiKubunCode();
    }

    /**
     * 受給者台帳_旧措置者フラグを取得します。
     *
     * @return 受給者台帳_旧措置者フラグ
     */
    public boolean is受給者台帳_旧措置者フラグ() {
        return 申請認定情報Entity.isDbT4001JukyushaDaicho_kyuSochishaFlag();
    }

    /**
     * 受給者台帳_資格取得前申請区分を取得します。
     *
     * @return 受給者台帳_資格取得前申請区分
     */
    public boolean is受給者台帳_資格取得前申請区分() {
        return 申請認定情報Entity.isDbT4001JukyushaDaicho_shikakuShutokuMaeShinseiFlag();
    }

    /**
     * 受給者台帳_みなし要介護区分コードを取得します。
     *
     * @return 受給者台帳_みなし要介護区分コード
     */
    public Code get受給者台帳_みなし要介護区分コード() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_minashiCode();
    }

    /**
     * 申請届出情報_申請届出者氏名を取得します。
     *
     * @return 申請届出情報_申請届出者氏名
     */
    public RString get申請届出情報_申請届出者氏名() {
        return 申請認定情報Entity.getDbT5120ShinseitodokedeJoho_shinseiTodokedeshaShimei();
    }

    /**
     * 要介護認定申請情報_認定申請理由を取得します。
     *
     * @return 要介護認定申請情報_認定申請理由
     */
    public RString get要介護認定申請情報_認定申請理由() {
        return 申請認定情報Entity.getDbT4101NinteiShinseiJoho_ninteiShinseiRiyu();
    }

    /**
     * 受給者台帳_データ区分を取得します。
     *
     * @return 受給者台帳_データ区分
     */
    public Code get受給者台帳_データ区分() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_dataKubun();
    }

    /**
     * 受給者台帳_認定年月日を取得します。
     *
     * @return 受給者台帳_認定年月日
     */
    public FlexibleDate get受給者台帳_認定年月日() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_ninteiYMD();
    }

    /**
     * 受給者台帳_直近異動年月日を取得します。
     *
     * @return 受給者台帳_直近異動年月日
     */
    public FlexibleDate get受給者台帳_直近異動年月日() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_chokkinIdoYMD();
    }

    /**
     * 受給者台帳_当初認定有効期間開始年月日を取得します。
     *
     * @return 受給者台帳_当初認定有効期間開始年月日
     */
    public FlexibleDate get受給者台帳_当初認定有効期間開始年月日() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_toshoNinteiYukoKaishiYMD();
    }

    /**
     * 受給者台帳_当初認定有効期間終了年月日を取得します。
     *
     * @return 受給者台帳_当初認定有効期間終了年月日
     */
    public FlexibleDate get受給者台帳_当初認定有効期間終了年月日() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_toshoNinteiYukoShuryoYMD();
    }

    /**
     * 受給者台帳_受給資格証明書発行年月日１を取得します。
     *
     * @return 受給者台帳_受給資格証明書発行年月日１
     */
    public FlexibleDate get受給者台帳_受給資格証明書発行年月日１() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_jukyuShikakuShomeishoHakkoYMD1();
    }

    /**
     * 受給者台帳_受給資格証明書発行年月日２を取得します。
     *
     * @return 受給者台帳_受給資格証明書発行年月日２
     */
    public FlexibleDate get受給者台帳_受給資格証明書発行年月日２() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_jukyuShikakuShomeishoHakkoYMD2();
    }

    /**
     * 受給者台帳_直近異動事由コードを取得します。
     *
     * @return 受給者台帳_直近異動事由コード
     */
    public Code get受給者台帳_直近異動事由コード() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_chokkinIdoJiyuCode();
    }

    /**
     * 受給者台帳_削除事由コードを取得します。
     *
     * @return 受給者台帳_削除事由コード
     */
    public Code get受給者台帳_削除事由コード() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_sakujoJiyuCode();
    }

    /**
     * 受給者台帳_異動理由を取得します。
     *
     * @return 受給者台帳_異動理由
     */
    public RString 受給者台帳_異動理由() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_idoRiyu();
    }

    /**
     * 受給者台帳_２号特定疾病コードを取得します。
     *
     * @return 受給者台帳_２号特定疾病コード
     */
    public Code get受給者台帳_２号特定疾病コード() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_nigoTokuteiShippeiCode();
    }

    /**
     * 受給者台帳_喪失年月日を取得します。
     *
     * @return 受給者台帳_喪失年月日
     */
    public FlexibleDate get受給者台帳_喪失年月日() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_soshitsuYMD();
    }

    /**
     * 要介護認定申請情報_認定申請区分申請時コードを取得します。
     *
     * @return 要介護認定申請情報_認定申請区分申請時コード
     */
    public Code get要介護認定申請情報_認定申請区分申請時コード() {
        return 申請認定情報Entity.getDbT4101NinteiShinseiJoho_ninteiShinseiShinseijiKubunCode();
    }

    /**
     * 要介護認定申請情報_認定申請区分法令コードを取得します。
     *
     * @return 要介護認定申請情報_認定申請区分法令コード
     */
    public Code get要介護認定申請情報_認定申請区分法令コード() {
        return 申請認定情報Entity.getDbT4101NinteiShinseiJoho_ninteiShinseiHoreiKubunCode();
    }

    /**
     * 要介護認定インターフェース情報_審査会意見を取得します。
     *
     * @return 要介護認定インターフェース情報_審査会意見
     */
    public RString get要介護認定インターフェース情報_審査会意見() {
        return 申請認定情報Entity.getDbT4003YokaigoNinteiInterface_shinsakaiIken();
    }

    /**
     * 前回要介護認定状態区分コードを取得します。
     *
     * @return 前回要介護認定状態区分コード
     */
    public Code get前回要介護認定状態区分コード() {
        return 申請認定情報Entity.get前回要介護状態区分コード();
    }

    /**
     * 前回認定年月日を取得します。
     *
     * @return 前回認定年月日
     */
    public FlexibleDate get前回認定年月日() {
        return 申請認定情報Entity.get前回認定年月日();
    }

    /**
     * 前回認定有効期間開始を取得します。
     *
     * @return 前回認定有効期間開始
     */
    public FlexibleDate get前回認定有効期間開始() {
        return 申請認定情報Entity.get前回有効期間開始();
    }

    /**
     * 前回認定有効期間終了を取得します。
     *
     * @return 前回認定有効期間終了
     */
    public FlexibleDate get前回認定有効期間終了() {
        return 申請認定情報Entity.get前回有効期間終了();
    }
    
    /**
     * 前回厚労省IF識別コードを取得します。
     * 
     * @return 前回厚労省IF識別コード
     */
    public Code get前回厚労省IF識別コード() {
        return 申請認定情報Entity.get前回厚労省IF識別コード();
    }

    /**
     * 指定サービス種類01を取得します。
     *
     * @return 指定サービス種類01
     */
    public ServiceShuruiCode get指定サービス種類01() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui01();
    }

    /**
     * 指定サービス種類02を取得します。
     *
     * @return 指定サービス種類02
     */
    public ServiceShuruiCode get指定サービス種類02() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui02();
    }

    /**
     * 指定サービス種類03を取得します。
     *
     * @return 指定サービス種類03
     */
    public ServiceShuruiCode get指定サービス種類03() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui03();
    }

    /**
     * 指定サービス種類04を取得します。
     *
     * @return 指定サービス種類04
     */
    public ServiceShuruiCode get指定サービス種類04() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui04();
    }

    /**
     * 指定サービス種類05を取得します。
     *
     * @return 指定サービス種類05
     */
    public ServiceShuruiCode get指定サービス種類05() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui05();
    }

    /**
     * 指定サービス種類06を取得します。
     *
     * @return 指定サービス種類06
     */
    public ServiceShuruiCode get指定サービス種類06() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui06();
    }

    /**
     * 指定サービス種類07を取得します。
     *
     * @return 指定サービス種類07
     */
    public ServiceShuruiCode get指定サービス種類07() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui07();
    }

    /**
     * 指定サービス種類08を取得します。
     *
     * @return 指定サービス種類08
     */
    public ServiceShuruiCode get指定サービス種類08() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui08();
    }

    /**
     * 指定サービス種類09を取得します。
     *
     * @return 指定サービス種類09
     */
    public ServiceShuruiCode get指定サービス種類09() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui09();
    }

    /**
     * 指定サービス種類10を取得します。
     *
     * @return 指定サービス種類10
     */
    public ServiceShuruiCode get指定サービス種類10() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui10();
    }

    /**
     * 指定サービス種類11を取得します。
     *
     * @return 指定サービス種類11
     */
    public ServiceShuruiCode get指定サービス種類11() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui11();
    }

    /**
     * 指定サービス種類12を取得します。
     *
     * @return 指定サービス種類12
     */
    public ServiceShuruiCode get指定サービス種類12() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui12();
    }

    /**
     * 指定サービス種類13を取得します。
     *
     * @return 指定サービス種類13
     */
    public ServiceShuruiCode get指定サービス種類13() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui13();
    }

    /**
     * 指定サービス種類14を取得します。
     *
     * @return 指定サービス種類14
     */
    public ServiceShuruiCode get指定サービス種類14() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui14();
    }

    /**
     * 指定サービス種類15を取得します。
     *
     * @return 指定サービス種類15
     */
    public ServiceShuruiCode get指定サービス種類15() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui15();
    }

    /**
     * 指定サービス種類16を取得します。
     *
     * @return 指定サービス種類16
     */
    public ServiceShuruiCode get指定サービス種類16() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui16();
    }

    /**
     * 指定サービス種類17を取得します。
     *
     * @return 指定サービス種類17
     */
    public ServiceShuruiCode get指定サービス種類17() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui17();
    }

    /**
     * 指定サービス種類18を取得します。
     *
     * @return 指定サービス種類18
     */
    public ServiceShuruiCode get指定サービス種類18() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui18();
    }

    /**
     * 指定サービス種類19を取得します。
     *
     * @return 指定サービス種類19
     */
    public ServiceShuruiCode get指定サービス種類19() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui19();
    }

    /**
     * 指定サービス種類20を取得します。
     *
     * @return 指定サービス種類20
     */
    public ServiceShuruiCode get指定サービス種類20() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui20();
    }

    /**
     * 指定サービス種類21を取得します。
     *
     * @return 指定サービス種類21
     */
    public ServiceShuruiCode get指定サービス種類21() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui21();
    }

    /**
     * 指定サービス種類22を取得します。
     *
     * @return 指定サービス種類22
     */
    public ServiceShuruiCode get指定サービス種類22() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui22();
    }

    /**
     * 指定サービス種類23を取得します。
     *
     * @return 指定サービス種類23
     */
    public ServiceShuruiCode get指定サービス種類23() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui23();
    }

    /**
     * 指定サービス種類24を取得します。
     *
     * @return 指定サービス種類24
     */
    public ServiceShuruiCode get指定サービス種類24() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui24();
    }

    /**
     * 指定サービス種類25を取得します。
     *
     * @return 指定サービス種類25
     */
    public ServiceShuruiCode get指定サービス種類25() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui25();
    }

    /**
     * 指定サービス種類26を取得します。
     *
     * @return 指定サービス種類26
     */
    public ServiceShuruiCode get指定サービス種類26() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui26();
    }

    /**
     * 指定サービス種類27を取得します。
     *
     * @return 指定サービス種類27
     */
    public ServiceShuruiCode get指定サービス種類27() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui27();
    }

    /**
     * 指定サービス種類28を取得します。
     *
     * @return 指定サービス種類28
     */
    public ServiceShuruiCode get指定サービス種類28() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui28();
    }

    /**
     * 指定サービス種類29を取得します。
     *
     * @return 指定サービス種類29
     */
    public ServiceShuruiCode get指定サービス種類29() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui29();
    }

    /**
     * 指定サービス種類30を取得します。
     *
     * @return 指定サービス種類30
     */
    public ServiceShuruiCode get指定サービス種類30() {
        return 申請認定情報Entity.getDbT4001JukyushaDaicho_shiteiServiceShurui30();
    }

    /**
     * 資格者証交付情報_有効期限を取得します。
     *
     * @return 資格者証交付情報_有効期限
     */
    public FlexibleDate get資格者証交付情報_有効期限() {
        return 申請認定情報Entity.getDbt7037_有効期限();
    }

    /**
     * 資格者証交付情報_交付年月日を取得します。
     *
     * @return 資格者証交付情報_交付年月日
     */
    public FlexibleDate get資格者証交付情報_交付年月日() {
        return 申請認定情報Entity.getDbt7037_交付年月日();
    }

}
