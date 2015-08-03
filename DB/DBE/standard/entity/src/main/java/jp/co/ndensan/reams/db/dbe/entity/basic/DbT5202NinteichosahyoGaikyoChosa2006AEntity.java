package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import java.util.Objects;

/**
 * 認定調査票（概況調査）2006Aテーブルのエンティティクラスです。
 */
public class DbT5202NinteichosahyoGaikyoChosa2006AEntity extends DbTableEntityBase<DbT5202NinteichosahyoGaikyoChosa2006AEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5202NinteichosahyoGaikyoChosa2006A");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD013ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private Code ninteichousaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private Code chosaItakuKubunCode;
    private Code ninteiChosaKubunCode;
    private DbUDD004JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private Code chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private RDateTime jisshiBashoImageSharedFileId;
    private Code genzainoJokyoCode;
    private Code serviceKubunCode;
    private int serviceJokyo01;
    private int serviceJokyo02;
    private int serviceJokyo03;
    private int serviceJokyo04;
    private int serviceJokyo05;
    private int serviceJokyo06;
    private int serviceJokyo07;
    private int serviceJokyo08;
    private int serviceJokyo09;
    private int serviceJokyo10;
    private int serviceJokyo11;
    private int serviceJokyo12;
    private int serviceJokyo13;
    private int serviceJokyo14;
    private int serviceJokyo15;
    private int serviceJokyo16;
    private int serviceJokyo17;
    private int serviceJokyo18;
    private int serviceJokyo19;
    private int serviceJokyo20;
    private int serviceJokyo21;
    private int serviceJokyo22;
    private int serviceJokyo23;
    private int serviceJokyo24;
    private int serviceJokyo25;
    private int serviceJokyo26;
    private int serviceJokyo27;
    private int serviceJokyo28;
    private int serviceJokyo29;
    private int serviceJokyo30;
    private boolean serviceJokyoFlag01;
    private boolean serviceJokyoFlag02;
    private boolean serviceJokyoFlag03;
    private boolean serviceJokyoFlag04;
    private boolean serviceJokyoFlag05;
    private boolean serviceJokyoFlag06;
    private boolean serviceJokyoFlag07;
    private boolean serviceJokyoFlag08;
    private boolean serviceJokyoFlag09;
    private boolean serviceJokyoFlag10;
    private RString serviceJokyoKinyu01;
    private RString serviceJokyoKinyu02;
    private RString serviceJokyoKinyu03;
    private RString serviceJokyoKinyu04;
    private RString serviceJokyoKinyu05;
    private RString serviceJokyoKinyu06;
    private RString serviceJokyoKinyu07;
    private RString serviceJokyoKinyu08;
    private RString serviceJokyoKinyu09;
    private RString serviceJokyoKinyu10;
    private RDateTime serviceJokyoImageSharedFileId01;
    private RDateTime serviceJokyoImageSharedFileId02;
    private RDateTime serviceJokyoImageSharedFileId03;
    private RDateTime serviceJokyoImageSharedFileId04;
    private RDateTime serviceJokyoImageSharedFileId05;
    private RDateTime serviceJokyoImageSharedFileId06;
    private RDateTime serviceJokyoImageSharedFileId07;
    private RDateTime serviceJokyoImageSharedFileId08;
    private RDateTime serviceJokyoImageSharedFileId09;
    private RDateTime serviceJokyoImageSharedFileId10;
    private boolean shisetsuRiyo01;
    private boolean shisetsuRiyo02;
    private boolean shisetsuRiyo03;
    private boolean shisetsuRiyo04;
    private boolean shisetsuRiyo05;
    private boolean shisetsuRiyo06;
    private boolean shisetsuRiyo07;
    private boolean shisetsuRiyo08;
    private boolean shisetsuRiyo09;
    private boolean shisetsuRiyo10;
    private RString riyoShisetsuShimei;
    private AtenaJusho riyoShisetsuJusho;
    private TelNo riyoShisetsuTelNo;
    private YubinNo riyoShisetsuYubinNo;
    private RDateTime riyoShisetsuNameImageSharedFileId;
    private RDateTime riyoShisetsuJushoImageSharedFileId;
    private RDateTime riyoShisetsuTelNoImageSharedFileId;
    private RString tokki;
    private RDateTime tokkiImageSharedFileId;
    private FlexibleDate tokkijikoUketsukeYMD;
    private FlexibleDate tokkijikoJuryoYMD;

    /**
     * insertDantaiCdのgetメソッドです。
     * 
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     * 
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     * 
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     * 
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     * 
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    public DbUDD013ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(DbUDD013ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 認定調査依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @return 認定調査依頼履歴番号
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * 認定調査依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     * 
     * @param ninteichosaRirekiNo 認定調査依頼履歴番号
     */
    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     * 
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     * 
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 認定調査依頼区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査依頼区分コード）
     * 
     * @return 認定調査依頼区分コード
     */
    public Code getNinteichousaIraiKubunCode() {
        return ninteichousaIraiKubunCode;
    }

    /**
     * 認定調査依頼区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査依頼区分コード）
     * 
     * @param ninteichousaIraiKubunCode 認定調査依頼区分コード
     */
    public void setNinteichousaIraiKubunCode(Code ninteichousaIraiKubunCode) {
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
    }

    /**
     * 認定調査回数のgetメソッドです。
     * 
     * @return 認定調査回数
     */
    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    /**
     * 認定調査回数のsetメソッドです。
     * 
     * @param ninteichosaIraiKaisu 認定調査回数
     */
    public void setNinteichosaIraiKaisu(int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    /**
     * 認定調査実施年月日のgetメソッドです。
     * 
     * @return 認定調査実施年月日
     */
    public FlexibleDate getNinteichosaJisshiYMD() {
        return ninteichosaJisshiYMD;
    }

    /**
     * 認定調査実施年月日のsetメソッドです。
     * 
     * @param ninteichosaJisshiYMD 認定調査実施年月日
     */
    public void setNinteichosaJisshiYMD(FlexibleDate ninteichosaJisshiYMD) {
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
    }

    /**
     * 認定調査受領年月日のgetメソッドです。
     * 
     * @return 認定調査受領年月日
     */
    public FlexibleDate getNinteichosaJuryoYMD() {
        return ninteichosaJuryoYMD;
    }

    /**
     * 認定調査受領年月日のsetメソッドです。
     * 
     * @param ninteichosaJuryoYMD 認定調査受領年月日
     */
    public void setNinteichosaJuryoYMD(FlexibleDate ninteichosaJuryoYMD) {
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
    }

    /**
     * 調査委託区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査委託区分）
     * 
     * @return 調査委託区分コード
     */
    public Code getChosaItakuKubunCode() {
        return chosaItakuKubunCode;
    }

    /**
     * 調査委託区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査委託区分）
     * 
     * @param chosaItakuKubunCode 調査委託区分コード
     */
    public void setChosaItakuKubunCode(Code chosaItakuKubunCode) {
        this.chosaItakuKubunCode = chosaItakuKubunCode;
    }

    /**
     * 認定調査区分コードのgetメソッドです。
     * 
     * @return 認定調査区分コード
     */
    public Code getNinteiChosaKubunCode() {
        return ninteiChosaKubunCode;
    }

    /**
     * 認定調査区分コードのsetメソッドです。
     * 
     * @param ninteiChosaKubunCode 認定調査区分コード
     */
    public void setNinteiChosaKubunCode(Code ninteiChosaKubunCode) {
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @return 認定調査委託先コード
     */
    public DbUDD004JigyoshaNo getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @param chosaItakusakiCode 認定調査委託先コード
     */
    public void setChosaItakusakiCode(DbUDD004JigyoshaNo chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     * 
     * @return 認定調査員コード
     */
    public RString getChosainCode() {
        return chosainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     * 
     * @param chosainCode 認定調査員コード
     */
    public void setChosainCode(RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    /**
     * 認定調査実施場所コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査実施場所コード）
     * 
     * @return 認定調査実施場所コード
     */
    public Code getChosaJisshiBashoCode() {
        return chosaJisshiBashoCode;
    }

    /**
     * 認定調査実施場所コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査実施場所コード）
     * 
     * @param chosaJisshiBashoCode 認定調査実施場所コード
     */
    public void setChosaJisshiBashoCode(Code chosaJisshiBashoCode) {
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
    }

    /**
     * 認定調査実施場所名称のgetメソッドです。
     * 
     * @return 認定調査実施場所名称
     */
    public RString getChosaJisshiBashoMeisho() {
        return chosaJisshiBashoMeisho;
    }

    /**
     * 認定調査実施場所名称のsetメソッドです。
     * 
     * @param chosaJisshiBashoMeisho 認定調査実施場所名称
     */
    public void setChosaJisshiBashoMeisho(RString chosaJisshiBashoMeisho) {
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
    }

    /**
     * 実施場所イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 実施場所イメージ共有ファイルID
     */
    public RDateTime getJisshiBashoImageSharedFileId() {
        return jisshiBashoImageSharedFileId;
    }

    /**
     * 実施場所イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param jisshiBashoImageSharedFileId 実施場所イメージ共有ファイルID
     */
    public void setJisshiBashoImageSharedFileId(RDateTime jisshiBashoImageSharedFileId) {
        this.jisshiBashoImageSharedFileId = jisshiBashoImageSharedFileId;
    }

    /**
     * 認定調査・現在の状況コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：現在の状況コード）
     * 
     * @return 認定調査・現在の状況コード
     */
    public Code getGenzainoJokyoCode() {
        return genzainoJokyoCode;
    }

    /**
     * 認定調査・現在の状況コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：現在の状況コード）
     * 
     * @param genzainoJokyoCode 認定調査・現在の状況コード
     */
    public void setGenzainoJokyoCode(Code genzainoJokyoCode) {
        this.genzainoJokyoCode = genzainoJokyoCode;
    }

    /**
     * 認定調査・サービス区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：現在のサービス区分コード）
     * 
     * @return 認定調査・サービス区分コード
     */
    public Code getServiceKubunCode() {
        return serviceKubunCode;
    }

    /**
     * 認定調査・サービス区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：現在のサービス区分コード）
     * 
     * @param serviceKubunCode 認定調査・サービス区分コード
     */
    public void setServiceKubunCode(Code serviceKubunCode) {
        this.serviceKubunCode = serviceKubunCode;
    }

    /**
     * サービスの状況01のgetメソッドです。
     * 
     * @return サービスの状況01
     */
    public int getServiceJokyo01() {
        return serviceJokyo01;
    }

    /**
     * サービスの状況01のsetメソッドです。
     * 
     * @param serviceJokyo01 サービスの状況01
     */
    public void setServiceJokyo01(int serviceJokyo01) {
        this.serviceJokyo01 = serviceJokyo01;
    }

    /**
     * サービスの状況02のgetメソッドです。
     * 
     * @return サービスの状況02
     */
    public int getServiceJokyo02() {
        return serviceJokyo02;
    }

    /**
     * サービスの状況02のsetメソッドです。
     * 
     * @param serviceJokyo02 サービスの状況02
     */
    public void setServiceJokyo02(int serviceJokyo02) {
        this.serviceJokyo02 = serviceJokyo02;
    }

    /**
     * サービスの状況03のgetメソッドです。
     * 
     * @return サービスの状況03
     */
    public int getServiceJokyo03() {
        return serviceJokyo03;
    }

    /**
     * サービスの状況03のsetメソッドです。
     * 
     * @param serviceJokyo03 サービスの状況03
     */
    public void setServiceJokyo03(int serviceJokyo03) {
        this.serviceJokyo03 = serviceJokyo03;
    }

    /**
     * サービスの状況04のgetメソッドです。
     * 
     * @return サービスの状況04
     */
    public int getServiceJokyo04() {
        return serviceJokyo04;
    }

    /**
     * サービスの状況04のsetメソッドです。
     * 
     * @param serviceJokyo04 サービスの状況04
     */
    public void setServiceJokyo04(int serviceJokyo04) {
        this.serviceJokyo04 = serviceJokyo04;
    }

    /**
     * サービスの状況05のgetメソッドです。
     * 
     * @return サービスの状況05
     */
    public int getServiceJokyo05() {
        return serviceJokyo05;
    }

    /**
     * サービスの状況05のsetメソッドです。
     * 
     * @param serviceJokyo05 サービスの状況05
     */
    public void setServiceJokyo05(int serviceJokyo05) {
        this.serviceJokyo05 = serviceJokyo05;
    }

    /**
     * サービスの状況06のgetメソッドです。
     * 
     * @return サービスの状況06
     */
    public int getServiceJokyo06() {
        return serviceJokyo06;
    }

    /**
     * サービスの状況06のsetメソッドです。
     * 
     * @param serviceJokyo06 サービスの状況06
     */
    public void setServiceJokyo06(int serviceJokyo06) {
        this.serviceJokyo06 = serviceJokyo06;
    }

    /**
     * サービスの状況07のgetメソッドです。
     * 
     * @return サービスの状況07
     */
    public int getServiceJokyo07() {
        return serviceJokyo07;
    }

    /**
     * サービスの状況07のsetメソッドです。
     * 
     * @param serviceJokyo07 サービスの状況07
     */
    public void setServiceJokyo07(int serviceJokyo07) {
        this.serviceJokyo07 = serviceJokyo07;
    }

    /**
     * サービスの状況08のgetメソッドです。
     * 
     * @return サービスの状況08
     */
    public int getServiceJokyo08() {
        return serviceJokyo08;
    }

    /**
     * サービスの状況08のsetメソッドです。
     * 
     * @param serviceJokyo08 サービスの状況08
     */
    public void setServiceJokyo08(int serviceJokyo08) {
        this.serviceJokyo08 = serviceJokyo08;
    }

    /**
     * サービスの状況09のgetメソッドです。
     * 
     * @return サービスの状況09
     */
    public int getServiceJokyo09() {
        return serviceJokyo09;
    }

    /**
     * サービスの状況09のsetメソッドです。
     * 
     * @param serviceJokyo09 サービスの状況09
     */
    public void setServiceJokyo09(int serviceJokyo09) {
        this.serviceJokyo09 = serviceJokyo09;
    }

    /**
     * サービスの状況10のgetメソッドです。
     * 
     * @return サービスの状況10
     */
    public int getServiceJokyo10() {
        return serviceJokyo10;
    }

    /**
     * サービスの状況10のsetメソッドです。
     * 
     * @param serviceJokyo10 サービスの状況10
     */
    public void setServiceJokyo10(int serviceJokyo10) {
        this.serviceJokyo10 = serviceJokyo10;
    }

    /**
     * サービスの状況11のgetメソッドです。
     * 
     * @return サービスの状況11
     */
    public int getServiceJokyo11() {
        return serviceJokyo11;
    }

    /**
     * サービスの状況11のsetメソッドです。
     * 
     * @param serviceJokyo11 サービスの状況11
     */
    public void setServiceJokyo11(int serviceJokyo11) {
        this.serviceJokyo11 = serviceJokyo11;
    }

    /**
     * サービスの状況12のgetメソッドです。
     * 
     * @return サービスの状況12
     */
    public int getServiceJokyo12() {
        return serviceJokyo12;
    }

    /**
     * サービスの状況12のsetメソッドです。
     * 
     * @param serviceJokyo12 サービスの状況12
     */
    public void setServiceJokyo12(int serviceJokyo12) {
        this.serviceJokyo12 = serviceJokyo12;
    }

    /**
     * サービスの状況13のgetメソッドです。
     * 
     * @return サービスの状況13
     */
    public int getServiceJokyo13() {
        return serviceJokyo13;
    }

    /**
     * サービスの状況13のsetメソッドです。
     * 
     * @param serviceJokyo13 サービスの状況13
     */
    public void setServiceJokyo13(int serviceJokyo13) {
        this.serviceJokyo13 = serviceJokyo13;
    }

    /**
     * サービスの状況14のgetメソッドです。
     * 
     * @return サービスの状況14
     */
    public int getServiceJokyo14() {
        return serviceJokyo14;
    }

    /**
     * サービスの状況14のsetメソッドです。
     * 
     * @param serviceJokyo14 サービスの状況14
     */
    public void setServiceJokyo14(int serviceJokyo14) {
        this.serviceJokyo14 = serviceJokyo14;
    }

    /**
     * サービスの状況15のgetメソッドです。
     * 
     * @return サービスの状況15
     */
    public int getServiceJokyo15() {
        return serviceJokyo15;
    }

    /**
     * サービスの状況15のsetメソッドです。
     * 
     * @param serviceJokyo15 サービスの状況15
     */
    public void setServiceJokyo15(int serviceJokyo15) {
        this.serviceJokyo15 = serviceJokyo15;
    }

    /**
     * サービスの状況16のgetメソッドです。
     * 
     * @return サービスの状況16
     */
    public int getServiceJokyo16() {
        return serviceJokyo16;
    }

    /**
     * サービスの状況16のsetメソッドです。
     * 
     * @param serviceJokyo16 サービスの状況16
     */
    public void setServiceJokyo16(int serviceJokyo16) {
        this.serviceJokyo16 = serviceJokyo16;
    }

    /**
     * サービスの状況17のgetメソッドです。
     * 
     * @return サービスの状況17
     */
    public int getServiceJokyo17() {
        return serviceJokyo17;
    }

    /**
     * サービスの状況17のsetメソッドです。
     * 
     * @param serviceJokyo17 サービスの状況17
     */
    public void setServiceJokyo17(int serviceJokyo17) {
        this.serviceJokyo17 = serviceJokyo17;
    }

    /**
     * サービスの状況18のgetメソッドです。
     * 
     * @return サービスの状況18
     */
    public int getServiceJokyo18() {
        return serviceJokyo18;
    }

    /**
     * サービスの状況18のsetメソッドです。
     * 
     * @param serviceJokyo18 サービスの状況18
     */
    public void setServiceJokyo18(int serviceJokyo18) {
        this.serviceJokyo18 = serviceJokyo18;
    }

    /**
     * サービスの状況19のgetメソッドです。
     * 
     * @return サービスの状況19
     */
    public int getServiceJokyo19() {
        return serviceJokyo19;
    }

    /**
     * サービスの状況19のsetメソッドです。
     * 
     * @param serviceJokyo19 サービスの状況19
     */
    public void setServiceJokyo19(int serviceJokyo19) {
        this.serviceJokyo19 = serviceJokyo19;
    }

    /**
     * サービスの状況20のgetメソッドです。
     * 
     * @return サービスの状況20
     */
    public int getServiceJokyo20() {
        return serviceJokyo20;
    }

    /**
     * サービスの状況20のsetメソッドです。
     * 
     * @param serviceJokyo20 サービスの状況20
     */
    public void setServiceJokyo20(int serviceJokyo20) {
        this.serviceJokyo20 = serviceJokyo20;
    }

    /**
     * サービスの状況21のgetメソッドです。
     * 
     * @return サービスの状況21
     */
    public int getServiceJokyo21() {
        return serviceJokyo21;
    }

    /**
     * サービスの状況21のsetメソッドです。
     * 
     * @param serviceJokyo21 サービスの状況21
     */
    public void setServiceJokyo21(int serviceJokyo21) {
        this.serviceJokyo21 = serviceJokyo21;
    }

    /**
     * サービスの状況22のgetメソッドです。
     * 
     * @return サービスの状況22
     */
    public int getServiceJokyo22() {
        return serviceJokyo22;
    }

    /**
     * サービスの状況22のsetメソッドです。
     * 
     * @param serviceJokyo22 サービスの状況22
     */
    public void setServiceJokyo22(int serviceJokyo22) {
        this.serviceJokyo22 = serviceJokyo22;
    }

    /**
     * サービスの状況23のgetメソッドです。
     * 
     * @return サービスの状況23
     */
    public int getServiceJokyo23() {
        return serviceJokyo23;
    }

    /**
     * サービスの状況23のsetメソッドです。
     * 
     * @param serviceJokyo23 サービスの状況23
     */
    public void setServiceJokyo23(int serviceJokyo23) {
        this.serviceJokyo23 = serviceJokyo23;
    }

    /**
     * サービスの状況24のgetメソッドです。
     * 
     * @return サービスの状況24
     */
    public int getServiceJokyo24() {
        return serviceJokyo24;
    }

    /**
     * サービスの状況24のsetメソッドです。
     * 
     * @param serviceJokyo24 サービスの状況24
     */
    public void setServiceJokyo24(int serviceJokyo24) {
        this.serviceJokyo24 = serviceJokyo24;
    }

    /**
     * サービスの状況25のgetメソッドです。
     * 
     * @return サービスの状況25
     */
    public int getServiceJokyo25() {
        return serviceJokyo25;
    }

    /**
     * サービスの状況25のsetメソッドです。
     * 
     * @param serviceJokyo25 サービスの状況25
     */
    public void setServiceJokyo25(int serviceJokyo25) {
        this.serviceJokyo25 = serviceJokyo25;
    }

    /**
     * サービスの状況26のgetメソッドです。
     * 
     * @return サービスの状況26
     */
    public int getServiceJokyo26() {
        return serviceJokyo26;
    }

    /**
     * サービスの状況26のsetメソッドです。
     * 
     * @param serviceJokyo26 サービスの状況26
     */
    public void setServiceJokyo26(int serviceJokyo26) {
        this.serviceJokyo26 = serviceJokyo26;
    }

    /**
     * サービスの状況27のgetメソッドです。
     * 
     * @return サービスの状況27
     */
    public int getServiceJokyo27() {
        return serviceJokyo27;
    }

    /**
     * サービスの状況27のsetメソッドです。
     * 
     * @param serviceJokyo27 サービスの状況27
     */
    public void setServiceJokyo27(int serviceJokyo27) {
        this.serviceJokyo27 = serviceJokyo27;
    }

    /**
     * サービスの状況28のgetメソッドです。
     * 
     * @return サービスの状況28
     */
    public int getServiceJokyo28() {
        return serviceJokyo28;
    }

    /**
     * サービスの状況28のsetメソッドです。
     * 
     * @param serviceJokyo28 サービスの状況28
     */
    public void setServiceJokyo28(int serviceJokyo28) {
        this.serviceJokyo28 = serviceJokyo28;
    }

    /**
     * サービスの状況29のgetメソッドです。
     * 
     * @return サービスの状況29
     */
    public int getServiceJokyo29() {
        return serviceJokyo29;
    }

    /**
     * サービスの状況29のsetメソッドです。
     * 
     * @param serviceJokyo29 サービスの状況29
     */
    public void setServiceJokyo29(int serviceJokyo29) {
        this.serviceJokyo29 = serviceJokyo29;
    }

    /**
     * サービスの状況30のgetメソッドです。
     * 
     * @return サービスの状況30
     */
    public int getServiceJokyo30() {
        return serviceJokyo30;
    }

    /**
     * サービスの状況30のsetメソッドです。
     * 
     * @param serviceJokyo30 サービスの状況30
     */
    public void setServiceJokyo30(int serviceJokyo30) {
        this.serviceJokyo30 = serviceJokyo30;
    }

    /**
     * サービスの状況フラグ01のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：住宅改修）参考です。
     * 
     * @return サービスの状況フラグ01
     */
    public boolean getServiceJokyoFlag01() {
        return serviceJokyoFlag01;
    }

    /**
     * サービスの状況フラグ01のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：住宅改修）参考です。
     * 
     * @param serviceJokyoFlag01 サービスの状況フラグ01
     */
    public void setServiceJokyoFlag01(boolean serviceJokyoFlag01) {
        this.serviceJokyoFlag01 = serviceJokyoFlag01;
    }

    /**
     * サービスの状況フラグ02のgetメソッドです。
     * 
     * @return サービスの状況フラグ02
     */
    public boolean getServiceJokyoFlag02() {
        return serviceJokyoFlag02;
    }

    /**
     * サービスの状況フラグ02のsetメソッドです。
     * 
     * @param serviceJokyoFlag02 サービスの状況フラグ02
     */
    public void setServiceJokyoFlag02(boolean serviceJokyoFlag02) {
        this.serviceJokyoFlag02 = serviceJokyoFlag02;
    }

    /**
     * サービスの状況フラグ03のgetメソッドです。
     * 
     * @return サービスの状況フラグ03
     */
    public boolean getServiceJokyoFlag03() {
        return serviceJokyoFlag03;
    }

    /**
     * サービスの状況フラグ03のsetメソッドです。
     * 
     * @param serviceJokyoFlag03 サービスの状況フラグ03
     */
    public void setServiceJokyoFlag03(boolean serviceJokyoFlag03) {
        this.serviceJokyoFlag03 = serviceJokyoFlag03;
    }

    /**
     * サービスの状況フラグ04のgetメソッドです。
     * 
     * @return サービスの状況フラグ04
     */
    public boolean getServiceJokyoFlag04() {
        return serviceJokyoFlag04;
    }

    /**
     * サービスの状況フラグ04のsetメソッドです。
     * 
     * @param serviceJokyoFlag04 サービスの状況フラグ04
     */
    public void setServiceJokyoFlag04(boolean serviceJokyoFlag04) {
        this.serviceJokyoFlag04 = serviceJokyoFlag04;
    }

    /**
     * サービスの状況フラグ05のgetメソッドです。
     * 
     * @return サービスの状況フラグ05
     */
    public boolean getServiceJokyoFlag05() {
        return serviceJokyoFlag05;
    }

    /**
     * サービスの状況フラグ05のsetメソッドです。
     * 
     * @param serviceJokyoFlag05 サービスの状況フラグ05
     */
    public void setServiceJokyoFlag05(boolean serviceJokyoFlag05) {
        this.serviceJokyoFlag05 = serviceJokyoFlag05;
    }

    /**
     * サービスの状況フラグ06のgetメソッドです。
     * 
     * @return サービスの状況フラグ06
     */
    public boolean getServiceJokyoFlag06() {
        return serviceJokyoFlag06;
    }

    /**
     * サービスの状況フラグ06のsetメソッドです。
     * 
     * @param serviceJokyoFlag06 サービスの状況フラグ06
     */
    public void setServiceJokyoFlag06(boolean serviceJokyoFlag06) {
        this.serviceJokyoFlag06 = serviceJokyoFlag06;
    }

    /**
     * サービスの状況フラグ07のgetメソッドです。
     * 
     * @return サービスの状況フラグ07
     */
    public boolean getServiceJokyoFlag07() {
        return serviceJokyoFlag07;
    }

    /**
     * サービスの状況フラグ07のsetメソッドです。
     * 
     * @param serviceJokyoFlag07 サービスの状況フラグ07
     */
    public void setServiceJokyoFlag07(boolean serviceJokyoFlag07) {
        this.serviceJokyoFlag07 = serviceJokyoFlag07;
    }

    /**
     * サービスの状況フラグ08のgetメソッドです。
     * 
     * @return サービスの状況フラグ08
     */
    public boolean getServiceJokyoFlag08() {
        return serviceJokyoFlag08;
    }

    /**
     * サービスの状況フラグ08のsetメソッドです。
     * 
     * @param serviceJokyoFlag08 サービスの状況フラグ08
     */
    public void setServiceJokyoFlag08(boolean serviceJokyoFlag08) {
        this.serviceJokyoFlag08 = serviceJokyoFlag08;
    }

    /**
     * サービスの状況フラグ09のgetメソッドです。
     * 
     * @return サービスの状況フラグ09
     */
    public boolean getServiceJokyoFlag09() {
        return serviceJokyoFlag09;
    }

    /**
     * サービスの状況フラグ09のsetメソッドです。
     * 
     * @param serviceJokyoFlag09 サービスの状況フラグ09
     */
    public void setServiceJokyoFlag09(boolean serviceJokyoFlag09) {
        this.serviceJokyoFlag09 = serviceJokyoFlag09;
    }

    /**
     * サービスの状況フラグ10のgetメソッドです。
     * 
     * @return サービスの状況フラグ10
     */
    public boolean getServiceJokyoFlag10() {
        return serviceJokyoFlag10;
    }

    /**
     * サービスの状況フラグ10のsetメソッドです。
     * 
     * @param serviceJokyoFlag10 サービスの状況フラグ10
     */
    public void setServiceJokyoFlag10(boolean serviceJokyoFlag10) {
        this.serviceJokyoFlag10 = serviceJokyoFlag10;
    }

    /**
     * サービスの状況記入01のgetメソッドです。
     * <br/>
     * <br/>市町村特別給付
     * 
     * @return サービスの状況記入01
     */
    public RString getServiceJokyoKinyu01() {
        return serviceJokyoKinyu01;
    }

    /**
     * サービスの状況記入01のsetメソッドです。
     * <br/>
     * <br/>市町村特別給付
     * 
     * @param serviceJokyoKinyu01 サービスの状況記入01
     */
    public void setServiceJokyoKinyu01(RString serviceJokyoKinyu01) {
        this.serviceJokyoKinyu01 = serviceJokyoKinyu01;
    }

    /**
     * サービスの状況記入02のgetメソッドです。
     * <br/>
     * <br/>介護保険給付外の在宅サービス
     * 
     * @return サービスの状況記入02
     */
    public RString getServiceJokyoKinyu02() {
        return serviceJokyoKinyu02;
    }

    /**
     * サービスの状況記入02のsetメソッドです。
     * <br/>
     * <br/>介護保険給付外の在宅サービス
     * 
     * @param serviceJokyoKinyu02 サービスの状況記入02
     */
    public void setServiceJokyoKinyu02(RString serviceJokyoKinyu02) {
        this.serviceJokyoKinyu02 = serviceJokyoKinyu02;
    }

    /**
     * サービスの状況記入03のgetメソッドです。
     * 
     * @return サービスの状況記入03
     */
    public RString getServiceJokyoKinyu03() {
        return serviceJokyoKinyu03;
    }

    /**
     * サービスの状況記入03のsetメソッドです。
     * 
     * @param serviceJokyoKinyu03 サービスの状況記入03
     */
    public void setServiceJokyoKinyu03(RString serviceJokyoKinyu03) {
        this.serviceJokyoKinyu03 = serviceJokyoKinyu03;
    }

    /**
     * サービスの状況記入04のgetメソッドです。
     * 
     * @return サービスの状況記入04
     */
    public RString getServiceJokyoKinyu04() {
        return serviceJokyoKinyu04;
    }

    /**
     * サービスの状況記入04のsetメソッドです。
     * 
     * @param serviceJokyoKinyu04 サービスの状況記入04
     */
    public void setServiceJokyoKinyu04(RString serviceJokyoKinyu04) {
        this.serviceJokyoKinyu04 = serviceJokyoKinyu04;
    }

    /**
     * サービスの状況記入05のgetメソッドです。
     * 
     * @return サービスの状況記入05
     */
    public RString getServiceJokyoKinyu05() {
        return serviceJokyoKinyu05;
    }

    /**
     * サービスの状況記入05のsetメソッドです。
     * 
     * @param serviceJokyoKinyu05 サービスの状況記入05
     */
    public void setServiceJokyoKinyu05(RString serviceJokyoKinyu05) {
        this.serviceJokyoKinyu05 = serviceJokyoKinyu05;
    }

    /**
     * サービスの状況記入06のgetメソッドです。
     * 
     * @return サービスの状況記入06
     */
    public RString getServiceJokyoKinyu06() {
        return serviceJokyoKinyu06;
    }

    /**
     * サービスの状況記入06のsetメソッドです。
     * 
     * @param serviceJokyoKinyu06 サービスの状況記入06
     */
    public void setServiceJokyoKinyu06(RString serviceJokyoKinyu06) {
        this.serviceJokyoKinyu06 = serviceJokyoKinyu06;
    }

    /**
     * サービスの状況記入07のgetメソッドです。
     * 
     * @return サービスの状況記入07
     */
    public RString getServiceJokyoKinyu07() {
        return serviceJokyoKinyu07;
    }

    /**
     * サービスの状況記入07のsetメソッドです。
     * 
     * @param serviceJokyoKinyu07 サービスの状況記入07
     */
    public void setServiceJokyoKinyu07(RString serviceJokyoKinyu07) {
        this.serviceJokyoKinyu07 = serviceJokyoKinyu07;
    }

    /**
     * サービスの状況記入08のgetメソッドです。
     * 
     * @return サービスの状況記入08
     */
    public RString getServiceJokyoKinyu08() {
        return serviceJokyoKinyu08;
    }

    /**
     * サービスの状況記入08のsetメソッドです。
     * 
     * @param serviceJokyoKinyu08 サービスの状況記入08
     */
    public void setServiceJokyoKinyu08(RString serviceJokyoKinyu08) {
        this.serviceJokyoKinyu08 = serviceJokyoKinyu08;
    }

    /**
     * サービスの状況記入09のgetメソッドです。
     * 
     * @return サービスの状況記入09
     */
    public RString getServiceJokyoKinyu09() {
        return serviceJokyoKinyu09;
    }

    /**
     * サービスの状況記入09のsetメソッドです。
     * 
     * @param serviceJokyoKinyu09 サービスの状況記入09
     */
    public void setServiceJokyoKinyu09(RString serviceJokyoKinyu09) {
        this.serviceJokyoKinyu09 = serviceJokyoKinyu09;
    }

    /**
     * サービスの状況記入10のgetメソッドです。
     * 
     * @return サービスの状況記入10
     */
    public RString getServiceJokyoKinyu10() {
        return serviceJokyoKinyu10;
    }

    /**
     * サービスの状況記入10のsetメソッドです。
     * 
     * @param serviceJokyoKinyu10 サービスの状況記入10
     */
    public void setServiceJokyoKinyu10(RString serviceJokyoKinyu10) {
        this.serviceJokyoKinyu10 = serviceJokyoKinyu10;
    }

    /**
     * サービスの状況イメージ共有ファイルID01のgetメソッドです。
     * <br/>
     * <br/>市町村特別給付
     * 
     * @return サービスの状況イメージ共有ファイルID01
     */
    public RDateTime getServiceJokyoImageSharedFileId01() {
        return serviceJokyoImageSharedFileId01;
    }

    /**
     * サービスの状況イメージ共有ファイルID01のsetメソッドです。
     * <br/>
     * <br/>市町村特別給付
     * 
     * @param serviceJokyoImageSharedFileId01 サービスの状況イメージ共有ファイルID01
     */
    public void setServiceJokyoImageSharedFileId01(RDateTime serviceJokyoImageSharedFileId01) {
        this.serviceJokyoImageSharedFileId01 = serviceJokyoImageSharedFileId01;
    }

    /**
     * サービスの状況イメージ共有ファイルID02のgetメソッドです。
     * <br/>
     * <br/>介護保険給付外の在宅サービス
     * 
     * @return サービスの状況イメージ共有ファイルID02
     */
    public RDateTime getServiceJokyoImageSharedFileId02() {
        return serviceJokyoImageSharedFileId02;
    }

    /**
     * サービスの状況イメージ共有ファイルID02のsetメソッドです。
     * <br/>
     * <br/>介護保険給付外の在宅サービス
     * 
     * @param serviceJokyoImageSharedFileId02 サービスの状況イメージ共有ファイルID02
     */
    public void setServiceJokyoImageSharedFileId02(RDateTime serviceJokyoImageSharedFileId02) {
        this.serviceJokyoImageSharedFileId02 = serviceJokyoImageSharedFileId02;
    }

    /**
     * サービスの状況イメージ共有ファイルID03のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID03
     */
    public RDateTime getServiceJokyoImageSharedFileId03() {
        return serviceJokyoImageSharedFileId03;
    }

    /**
     * サービスの状況イメージ共有ファイルID03のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId03 サービスの状況イメージ共有ファイルID03
     */
    public void setServiceJokyoImageSharedFileId03(RDateTime serviceJokyoImageSharedFileId03) {
        this.serviceJokyoImageSharedFileId03 = serviceJokyoImageSharedFileId03;
    }

    /**
     * サービスの状況イメージ共有ファイルID04のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID04
     */
    public RDateTime getServiceJokyoImageSharedFileId04() {
        return serviceJokyoImageSharedFileId04;
    }

    /**
     * サービスの状況イメージ共有ファイルID04のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId04 サービスの状況イメージ共有ファイルID04
     */
    public void setServiceJokyoImageSharedFileId04(RDateTime serviceJokyoImageSharedFileId04) {
        this.serviceJokyoImageSharedFileId04 = serviceJokyoImageSharedFileId04;
    }

    /**
     * サービスの状況イメージ共有ファイルID05のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID05
     */
    public RDateTime getServiceJokyoImageSharedFileId05() {
        return serviceJokyoImageSharedFileId05;
    }

    /**
     * サービスの状況イメージ共有ファイルID05のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId05 サービスの状況イメージ共有ファイルID05
     */
    public void setServiceJokyoImageSharedFileId05(RDateTime serviceJokyoImageSharedFileId05) {
        this.serviceJokyoImageSharedFileId05 = serviceJokyoImageSharedFileId05;
    }

    /**
     * サービスの状況イメージ共有ファイルID06のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID06
     */
    public RDateTime getServiceJokyoImageSharedFileId06() {
        return serviceJokyoImageSharedFileId06;
    }

    /**
     * サービスの状況イメージ共有ファイルID06のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId06 サービスの状況イメージ共有ファイルID06
     */
    public void setServiceJokyoImageSharedFileId06(RDateTime serviceJokyoImageSharedFileId06) {
        this.serviceJokyoImageSharedFileId06 = serviceJokyoImageSharedFileId06;
    }

    /**
     * サービスの状況イメージ共有ファイルID07のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID07
     */
    public RDateTime getServiceJokyoImageSharedFileId07() {
        return serviceJokyoImageSharedFileId07;
    }

    /**
     * サービスの状況イメージ共有ファイルID07のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId07 サービスの状況イメージ共有ファイルID07
     */
    public void setServiceJokyoImageSharedFileId07(RDateTime serviceJokyoImageSharedFileId07) {
        this.serviceJokyoImageSharedFileId07 = serviceJokyoImageSharedFileId07;
    }

    /**
     * サービスの状況イメージ共有ファイルID08のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID08
     */
    public RDateTime getServiceJokyoImageSharedFileId08() {
        return serviceJokyoImageSharedFileId08;
    }

    /**
     * サービスの状況イメージ共有ファイルID08のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId08 サービスの状況イメージ共有ファイルID08
     */
    public void setServiceJokyoImageSharedFileId08(RDateTime serviceJokyoImageSharedFileId08) {
        this.serviceJokyoImageSharedFileId08 = serviceJokyoImageSharedFileId08;
    }

    /**
     * サービスの状況イメージ共有ファイルID09のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID09
     */
    public RDateTime getServiceJokyoImageSharedFileId09() {
        return serviceJokyoImageSharedFileId09;
    }

    /**
     * サービスの状況イメージ共有ファイルID09のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId09 サービスの状況イメージ共有ファイルID09
     */
    public void setServiceJokyoImageSharedFileId09(RDateTime serviceJokyoImageSharedFileId09) {
        this.serviceJokyoImageSharedFileId09 = serviceJokyoImageSharedFileId09;
    }

    /**
     * サービスの状況イメージ共有ファイルID10のgetメソッドです。
     * 
     * @return サービスの状況イメージ共有ファイルID10
     */
    public RDateTime getServiceJokyoImageSharedFileId10() {
        return serviceJokyoImageSharedFileId10;
    }

    /**
     * サービスの状況イメージ共有ファイルID10のsetメソッドです。
     * 
     * @param serviceJokyoImageSharedFileId10 サービスの状況イメージ共有ファイルID10
     */
    public void setServiceJokyoImageSharedFileId10(RDateTime serviceJokyoImageSharedFileId10) {
        this.serviceJokyoImageSharedFileId10 = serviceJokyoImageSharedFileId10;
    }

    /**
     * 施設利用01のgetメソッドです。
     * 
     * @return 施設利用01
     */
    public boolean getShisetsuRiyo01() {
        return shisetsuRiyo01;
    }

    /**
     * 施設利用01のsetメソッドです。
     * 
     * @param shisetsuRiyo01 施設利用01
     */
    public void setShisetsuRiyo01(boolean shisetsuRiyo01) {
        this.shisetsuRiyo01 = shisetsuRiyo01;
    }

    /**
     * 施設利用02のgetメソッドです。
     * 
     * @return 施設利用02
     */
    public boolean getShisetsuRiyo02() {
        return shisetsuRiyo02;
    }

    /**
     * 施設利用02のsetメソッドです。
     * 
     * @param shisetsuRiyo02 施設利用02
     */
    public void setShisetsuRiyo02(boolean shisetsuRiyo02) {
        this.shisetsuRiyo02 = shisetsuRiyo02;
    }

    /**
     * 施設利用03のgetメソッドです。
     * 
     * @return 施設利用03
     */
    public boolean getShisetsuRiyo03() {
        return shisetsuRiyo03;
    }

    /**
     * 施設利用03のsetメソッドです。
     * 
     * @param shisetsuRiyo03 施設利用03
     */
    public void setShisetsuRiyo03(boolean shisetsuRiyo03) {
        this.shisetsuRiyo03 = shisetsuRiyo03;
    }

    /**
     * 施設利用04のgetメソッドです。
     * 
     * @return 施設利用04
     */
    public boolean getShisetsuRiyo04() {
        return shisetsuRiyo04;
    }

    /**
     * 施設利用04のsetメソッドです。
     * 
     * @param shisetsuRiyo04 施設利用04
     */
    public void setShisetsuRiyo04(boolean shisetsuRiyo04) {
        this.shisetsuRiyo04 = shisetsuRiyo04;
    }

    /**
     * 施設利用05のgetメソッドです。
     * 
     * @return 施設利用05
     */
    public boolean getShisetsuRiyo05() {
        return shisetsuRiyo05;
    }

    /**
     * 施設利用05のsetメソッドです。
     * 
     * @param shisetsuRiyo05 施設利用05
     */
    public void setShisetsuRiyo05(boolean shisetsuRiyo05) {
        this.shisetsuRiyo05 = shisetsuRiyo05;
    }

    /**
     * 施設利用06のgetメソッドです。
     * 
     * @return 施設利用06
     */
    public boolean getShisetsuRiyo06() {
        return shisetsuRiyo06;
    }

    /**
     * 施設利用06のsetメソッドです。
     * 
     * @param shisetsuRiyo06 施設利用06
     */
    public void setShisetsuRiyo06(boolean shisetsuRiyo06) {
        this.shisetsuRiyo06 = shisetsuRiyo06;
    }

    /**
     * 施設利用07のgetメソッドです。
     * 
     * @return 施設利用07
     */
    public boolean getShisetsuRiyo07() {
        return shisetsuRiyo07;
    }

    /**
     * 施設利用07のsetメソッドです。
     * 
     * @param shisetsuRiyo07 施設利用07
     */
    public void setShisetsuRiyo07(boolean shisetsuRiyo07) {
        this.shisetsuRiyo07 = shisetsuRiyo07;
    }

    /**
     * 施設利用08のgetメソッドです。
     * 
     * @return 施設利用08
     */
    public boolean getShisetsuRiyo08() {
        return shisetsuRiyo08;
    }

    /**
     * 施設利用08のsetメソッドです。
     * 
     * @param shisetsuRiyo08 施設利用08
     */
    public void setShisetsuRiyo08(boolean shisetsuRiyo08) {
        this.shisetsuRiyo08 = shisetsuRiyo08;
    }

    /**
     * 施設利用09のgetメソッドです。
     * 
     * @return 施設利用09
     */
    public boolean getShisetsuRiyo09() {
        return shisetsuRiyo09;
    }

    /**
     * 施設利用09のsetメソッドです。
     * 
     * @param shisetsuRiyo09 施設利用09
     */
    public void setShisetsuRiyo09(boolean shisetsuRiyo09) {
        this.shisetsuRiyo09 = shisetsuRiyo09;
    }

    /**
     * 施設利用10のgetメソッドです。
     * 
     * @return 施設利用10
     */
    public boolean getShisetsuRiyo10() {
        return shisetsuRiyo10;
    }

    /**
     * 施設利用10のsetメソッドです。
     * 
     * @param shisetsuRiyo10 施設利用10
     */
    public void setShisetsuRiyo10(boolean shisetsuRiyo10) {
        this.shisetsuRiyo10 = shisetsuRiyo10;
    }

    /**
     * 利用施設名のgetメソッドです。
     * 
     * @return 利用施設名
     */
    public RString getRiyoShisetsuShimei() {
        return riyoShisetsuShimei;
    }

    /**
     * 利用施設名のsetメソッドです。
     * 
     * @param riyoShisetsuShimei 利用施設名
     */
    public void setRiyoShisetsuShimei(RString riyoShisetsuShimei) {
        this.riyoShisetsuShimei = riyoShisetsuShimei;
    }

    /**
     * 利用施設住所のgetメソッドです。
     * 
     * @return 利用施設住所
     */
    public AtenaJusho getRiyoShisetsuJusho() {
        return riyoShisetsuJusho;
    }

    /**
     * 利用施設住所のsetメソッドです。
     * 
     * @param riyoShisetsuJusho 利用施設住所
     */
    public void setRiyoShisetsuJusho(AtenaJusho riyoShisetsuJusho) {
        this.riyoShisetsuJusho = riyoShisetsuJusho;
    }

    /**
     * 利用施設電話番号のgetメソッドです。
     * 
     * @return 利用施設電話番号
     */
    public TelNo getRiyoShisetsuTelNo() {
        return riyoShisetsuTelNo;
    }

    /**
     * 利用施設電話番号のsetメソッドです。
     * 
     * @param riyoShisetsuTelNo 利用施設電話番号
     */
    public void setRiyoShisetsuTelNo(TelNo riyoShisetsuTelNo) {
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
    }

    /**
     * 利用施設郵便番号のgetメソッドです。
     * 
     * @return 利用施設郵便番号
     */
    public YubinNo getRiyoShisetsuYubinNo() {
        return riyoShisetsuYubinNo;
    }

    /**
     * 利用施設郵便番号のsetメソッドです。
     * 
     * @param riyoShisetsuYubinNo 利用施設郵便番号
     */
    public void setRiyoShisetsuYubinNo(YubinNo riyoShisetsuYubinNo) {
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
    }

    /**
     * 利用施設名イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 利用施設名イメージ共有ファイルID
     */
    public RDateTime getRiyoShisetsuNameImageSharedFileId() {
        return riyoShisetsuNameImageSharedFileId;
    }

    /**
     * 利用施設名イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param riyoShisetsuNameImageSharedFileId 利用施設名イメージ共有ファイルID
     */
    public void setRiyoShisetsuNameImageSharedFileId(RDateTime riyoShisetsuNameImageSharedFileId) {
        this.riyoShisetsuNameImageSharedFileId = riyoShisetsuNameImageSharedFileId;
    }

    /**
     * 利用施設住所イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 利用施設住所イメージ共有ファイルID
     */
    public RDateTime getRiyoShisetsuJushoImageSharedFileId() {
        return riyoShisetsuJushoImageSharedFileId;
    }

    /**
     * 利用施設住所イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param riyoShisetsuJushoImageSharedFileId 利用施設住所イメージ共有ファイルID
     */
    public void setRiyoShisetsuJushoImageSharedFileId(RDateTime riyoShisetsuJushoImageSharedFileId) {
        this.riyoShisetsuJushoImageSharedFileId = riyoShisetsuJushoImageSharedFileId;
    }

    /**
     * 利用施設電話番号イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 利用施設電話番号イメージ共有ファイルID
     */
    public RDateTime getRiyoShisetsuTelNoImageSharedFileId() {
        return riyoShisetsuTelNoImageSharedFileId;
    }

    /**
     * 利用施設電話番号イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param riyoShisetsuTelNoImageSharedFileId 利用施設電話番号イメージ共有ファイルID
     */
    public void setRiyoShisetsuTelNoImageSharedFileId(RDateTime riyoShisetsuTelNoImageSharedFileId) {
        this.riyoShisetsuTelNoImageSharedFileId = riyoShisetsuTelNoImageSharedFileId;
    }

    /**
     * 特記のgetメソッドです。
     * 
     * @return 特記
     */
    public RString getTokki() {
        return tokki;
    }

    /**
     * 特記のsetメソッドです。
     * 
     * @param tokki 特記
     */
    public void setTokki(RString tokki) {
        this.tokki = tokki;
    }

    /**
     * 特記イメージ共有ファイルIDのgetメソッドです。
     * 
     * @return 特記イメージ共有ファイルID
     */
    public RDateTime getTokkiImageSharedFileId() {
        return tokkiImageSharedFileId;
    }

    /**
     * 特記イメージ共有ファイルIDのsetメソッドです。
     * 
     * @param tokkiImageSharedFileId 特記イメージ共有ファイルID
     */
    public void setTokkiImageSharedFileId(RDateTime tokkiImageSharedFileId) {
        this.tokkiImageSharedFileId = tokkiImageSharedFileId;
    }

    /**
     * 認定調査特記事項受付年月日のgetメソッドです。
     * 
     * @return 認定調査特記事項受付年月日
     */
    public FlexibleDate getTokkijikoUketsukeYMD() {
        return tokkijikoUketsukeYMD;
    }

    /**
     * 認定調査特記事項受付年月日のsetメソッドです。
     * 
     * @param tokkijikoUketsukeYMD 認定調査特記事項受付年月日
     */
    public void setTokkijikoUketsukeYMD(FlexibleDate tokkijikoUketsukeYMD) {
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
    }

    /**
     * 認定調査特記事項受領年月日のgetメソッドです。
     * 
     * @return 認定調査特記事項受領年月日
     */
    public FlexibleDate getTokkijikoJuryoYMD() {
        return tokkijikoJuryoYMD;
    }

    /**
     * 認定調査特記事項受領年月日のsetメソッドです。
     * 
     * @param tokkijikoJuryoYMD 認定調査特記事項受領年月日
     */
    public void setTokkijikoJuryoYMD(FlexibleDate tokkijikoJuryoYMD) {
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5202NinteichosahyoGaikyoChosa2006AEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5202NinteichosahyoGaikyoChosa2006AEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5202NinteichosahyoGaikyoChosa2006AEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5202NinteichosahyoGaikyoChosa2006AEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ninteichousaIraiKubunCode = entity.ninteichousaIraiKubunCode;
        this.ninteichosaIraiKaisu = entity.ninteichosaIraiKaisu;
        this.ninteichosaJisshiYMD = entity.ninteichosaJisshiYMD;
        this.ninteichosaJuryoYMD = entity.ninteichosaJuryoYMD;
        this.chosaItakuKubunCode = entity.chosaItakuKubunCode;
        this.ninteiChosaKubunCode = entity.ninteiChosaKubunCode;
        this.chosaItakusakiCode = entity.chosaItakusakiCode;
        this.chosainCode = entity.chosainCode;
        this.chosaJisshiBashoCode = entity.chosaJisshiBashoCode;
        this.chosaJisshiBashoMeisho = entity.chosaJisshiBashoMeisho;
        this.jisshiBashoImageSharedFileId = entity.jisshiBashoImageSharedFileId;
        this.genzainoJokyoCode = entity.genzainoJokyoCode;
        this.serviceKubunCode = entity.serviceKubunCode;
        this.serviceJokyo01 = entity.serviceJokyo01;
        this.serviceJokyo02 = entity.serviceJokyo02;
        this.serviceJokyo03 = entity.serviceJokyo03;
        this.serviceJokyo04 = entity.serviceJokyo04;
        this.serviceJokyo05 = entity.serviceJokyo05;
        this.serviceJokyo06 = entity.serviceJokyo06;
        this.serviceJokyo07 = entity.serviceJokyo07;
        this.serviceJokyo08 = entity.serviceJokyo08;
        this.serviceJokyo09 = entity.serviceJokyo09;
        this.serviceJokyo10 = entity.serviceJokyo10;
        this.serviceJokyo11 = entity.serviceJokyo11;
        this.serviceJokyo12 = entity.serviceJokyo12;
        this.serviceJokyo13 = entity.serviceJokyo13;
        this.serviceJokyo14 = entity.serviceJokyo14;
        this.serviceJokyo15 = entity.serviceJokyo15;
        this.serviceJokyo16 = entity.serviceJokyo16;
        this.serviceJokyo17 = entity.serviceJokyo17;
        this.serviceJokyo18 = entity.serviceJokyo18;
        this.serviceJokyo19 = entity.serviceJokyo19;
        this.serviceJokyo20 = entity.serviceJokyo20;
        this.serviceJokyo21 = entity.serviceJokyo21;
        this.serviceJokyo22 = entity.serviceJokyo22;
        this.serviceJokyo23 = entity.serviceJokyo23;
        this.serviceJokyo24 = entity.serviceJokyo24;
        this.serviceJokyo25 = entity.serviceJokyo25;
        this.serviceJokyo26 = entity.serviceJokyo26;
        this.serviceJokyo27 = entity.serviceJokyo27;
        this.serviceJokyo28 = entity.serviceJokyo28;
        this.serviceJokyo29 = entity.serviceJokyo29;
        this.serviceJokyo30 = entity.serviceJokyo30;
        this.serviceJokyoFlag01 = entity.serviceJokyoFlag01;
        this.serviceJokyoFlag02 = entity.serviceJokyoFlag02;
        this.serviceJokyoFlag03 = entity.serviceJokyoFlag03;
        this.serviceJokyoFlag04 = entity.serviceJokyoFlag04;
        this.serviceJokyoFlag05 = entity.serviceJokyoFlag05;
        this.serviceJokyoFlag06 = entity.serviceJokyoFlag06;
        this.serviceJokyoFlag07 = entity.serviceJokyoFlag07;
        this.serviceJokyoFlag08 = entity.serviceJokyoFlag08;
        this.serviceJokyoFlag09 = entity.serviceJokyoFlag09;
        this.serviceJokyoFlag10 = entity.serviceJokyoFlag10;
        this.serviceJokyoKinyu01 = entity.serviceJokyoKinyu01;
        this.serviceJokyoKinyu02 = entity.serviceJokyoKinyu02;
        this.serviceJokyoKinyu03 = entity.serviceJokyoKinyu03;
        this.serviceJokyoKinyu04 = entity.serviceJokyoKinyu04;
        this.serviceJokyoKinyu05 = entity.serviceJokyoKinyu05;
        this.serviceJokyoKinyu06 = entity.serviceJokyoKinyu06;
        this.serviceJokyoKinyu07 = entity.serviceJokyoKinyu07;
        this.serviceJokyoKinyu08 = entity.serviceJokyoKinyu08;
        this.serviceJokyoKinyu09 = entity.serviceJokyoKinyu09;
        this.serviceJokyoKinyu10 = entity.serviceJokyoKinyu10;
        this.serviceJokyoImageSharedFileId01 = entity.serviceJokyoImageSharedFileId01;
        this.serviceJokyoImageSharedFileId02 = entity.serviceJokyoImageSharedFileId02;
        this.serviceJokyoImageSharedFileId03 = entity.serviceJokyoImageSharedFileId03;
        this.serviceJokyoImageSharedFileId04 = entity.serviceJokyoImageSharedFileId04;
        this.serviceJokyoImageSharedFileId05 = entity.serviceJokyoImageSharedFileId05;
        this.serviceJokyoImageSharedFileId06 = entity.serviceJokyoImageSharedFileId06;
        this.serviceJokyoImageSharedFileId07 = entity.serviceJokyoImageSharedFileId07;
        this.serviceJokyoImageSharedFileId08 = entity.serviceJokyoImageSharedFileId08;
        this.serviceJokyoImageSharedFileId09 = entity.serviceJokyoImageSharedFileId09;
        this.serviceJokyoImageSharedFileId10 = entity.serviceJokyoImageSharedFileId10;
        this.shisetsuRiyo01 = entity.shisetsuRiyo01;
        this.shisetsuRiyo02 = entity.shisetsuRiyo02;
        this.shisetsuRiyo03 = entity.shisetsuRiyo03;
        this.shisetsuRiyo04 = entity.shisetsuRiyo04;
        this.shisetsuRiyo05 = entity.shisetsuRiyo05;
        this.shisetsuRiyo06 = entity.shisetsuRiyo06;
        this.shisetsuRiyo07 = entity.shisetsuRiyo07;
        this.shisetsuRiyo08 = entity.shisetsuRiyo08;
        this.shisetsuRiyo09 = entity.shisetsuRiyo09;
        this.shisetsuRiyo10 = entity.shisetsuRiyo10;
        this.riyoShisetsuShimei = entity.riyoShisetsuShimei;
        this.riyoShisetsuJusho = entity.riyoShisetsuJusho;
        this.riyoShisetsuTelNo = entity.riyoShisetsuTelNo;
        this.riyoShisetsuYubinNo = entity.riyoShisetsuYubinNo;
        this.riyoShisetsuNameImageSharedFileId = entity.riyoShisetsuNameImageSharedFileId;
        this.riyoShisetsuJushoImageSharedFileId = entity.riyoShisetsuJushoImageSharedFileId;
        this.riyoShisetsuTelNoImageSharedFileId = entity.riyoShisetsuTelNoImageSharedFileId;
        this.tokki = entity.tokki;
        this.tokkiImageSharedFileId = entity.tokkiImageSharedFileId;
        this.tokkijikoUketsukeYMD = entity.tokkijikoUketsukeYMD;
        this.tokkijikoJuryoYMD = entity.tokkijikoJuryoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, koroshoIfShikibetsuCode, ninteichousaIraiKubunCode, ninteichosaIraiKaisu, ninteichosaJisshiYMD, ninteichosaJuryoYMD, chosaItakuKubunCode, ninteiChosaKubunCode, chosaItakusakiCode, chosainCode, chosaJisshiBashoCode, chosaJisshiBashoMeisho, jisshiBashoImageSharedFileId, genzainoJokyoCode, serviceKubunCode, serviceJokyo01, serviceJokyo02, serviceJokyo03, serviceJokyo04, serviceJokyo05, serviceJokyo06, serviceJokyo07, serviceJokyo08, serviceJokyo09, serviceJokyo10, serviceJokyo11, serviceJokyo12, serviceJokyo13, serviceJokyo14, serviceJokyo15, serviceJokyo16, serviceJokyo17, serviceJokyo18, serviceJokyo19, serviceJokyo20, serviceJokyo21, serviceJokyo22, serviceJokyo23, serviceJokyo24, serviceJokyo25, serviceJokyo26, serviceJokyo27, serviceJokyo28, serviceJokyo29, serviceJokyo30, serviceJokyoFlag01, serviceJokyoFlag02, serviceJokyoFlag03, serviceJokyoFlag04, serviceJokyoFlag05, serviceJokyoFlag06, serviceJokyoFlag07, serviceJokyoFlag08, serviceJokyoFlag09, serviceJokyoFlag10, serviceJokyoKinyu01, serviceJokyoKinyu02, serviceJokyoKinyu03, serviceJokyoKinyu04, serviceJokyoKinyu05, serviceJokyoKinyu06, serviceJokyoKinyu07, serviceJokyoKinyu08, serviceJokyoKinyu09, serviceJokyoKinyu10, serviceJokyoImageSharedFileId01, serviceJokyoImageSharedFileId02, serviceJokyoImageSharedFileId03, serviceJokyoImageSharedFileId04, serviceJokyoImageSharedFileId05, serviceJokyoImageSharedFileId06, serviceJokyoImageSharedFileId07, serviceJokyoImageSharedFileId08, serviceJokyoImageSharedFileId09, serviceJokyoImageSharedFileId10, shisetsuRiyo01, shisetsuRiyo02, shisetsuRiyo03, shisetsuRiyo04, shisetsuRiyo05, shisetsuRiyo06, shisetsuRiyo07, shisetsuRiyo08, shisetsuRiyo09, shisetsuRiyo10, riyoShisetsuShimei, riyoShisetsuJusho, riyoShisetsuTelNo, riyoShisetsuYubinNo, riyoShisetsuNameImageSharedFileId, riyoShisetsuJushoImageSharedFileId, riyoShisetsuTelNoImageSharedFileId, tokki, tokkiImageSharedFileId, tokkijikoUketsukeYMD, tokkijikoJuryoYMD);
    }

// </editor-fold>
}
