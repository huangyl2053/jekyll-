/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.basic;

import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * T1001HihokenshaDaichoのEntityクラスです。
 *
 * @author N3327 三浦 凌
 */
public class DbT1001HihokenshaDaichoEntity implements IDbAccessable {

    /**
     * テーブル名
     */
    @TableName
    public static final RString TABLE_BANE = new RString("T1001HihokennshaDaicho");
    @PrimaryKey
    private RString shichosonCd;
    @PrimaryKey
    private RString hihokenshaNo;
    /* その他 */
    private IShikibetsuCode shikibetsuCode;
    private RString shikakuIdouKubunCode;
    private RDate shikakuShutokuTodokedeDate;
    private RString shikakuShutokuJiyuCode;
    private RDate shikakuShutokuDate;
    private RDate ichigoHihokenshaNenreiTotatsuDate;
    private RString hihokenshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private RDate shikakuSoshitsuTodokedeDate;
    private RDate shikakuSoshitsuDate;
    private RString shikakuHenkoJiyuCode;
    private RDate shikakuHenkoTodokedeDate;
    private RDate shikakuHenkoDate;
    private RString jushochitokureiTekiyoJiyuCode;
    private RDate jushochitokureiTekiyoTodokedeDate;
    private RDate jushochitokureiTekiyoDate;
    private RString jushochitokureiKaijoJiyuCode;
    private RDate jushochitokureiKaijoTodokedeDate;
    private RDate jushochitokureiKaijoDate;
    private boolean jushochitokureiFlag;
    private boolean koikinaiJushochitokureiFlag;
    private RString koikinaiTokureiSochimotoShichosonCd;
    private boolean saikofuKubun;
    private RString saikofuJiyuCode;

    /**
     * 空のコンストラクタを生成します。
     */
    public DbT1001HihokenshaDaichoEntity() {
    }

    /**
     * 被保険者から被保険者台帳エンティティのコンストラクタを生成します。
     *
     * @param 被保険者 被保険者
     * @throws NullPointerException 被保険者がnullのとき。
     */
    public DbT1001HihokenshaDaichoEntity(Hihokensha 被保険者) throws NullPointerException {
        this.shichosonCd = 被保険者.get市町村コード().getValue();
        this.hihokenshaNo = 被保険者.get被保険者番号();
        this.shikibetsuCode = 被保険者.get識別コード();
        this.shikakuIdouKubunCode = 被保険者.get資格異動区分().getCode();
        this.shikakuShutokuTodokedeDate = 被保険者.get資格取得届出年月日();
        this.shikakuShutokuJiyuCode = 被保険者.get資格取得事由().getCode();
        this.shikakuShutokuDate = 被保険者.get資格取得年月日();
        this.ichigoHihokenshaNenreiTotatsuDate = 被保険者.get一号該当日();
        this.hihokenshaKubunCode = 被保険者.get被保険者区分().getCode();
        this.shikakuSoshitsuJiyuCode = 被保険者.get資格取得事由().getCode();
        this.shikakuSoshitsuTodokedeDate = 被保険者.get資格喪失届出年月日();
        this.shikakuSoshitsuDate = 被保険者.get資格喪失年月日();
        this.shikakuHenkoJiyuCode = 被保険者.get資格変更事由().getCode();
        this.shikakuHenkoTodokedeDate = 被保険者.get資格変更届出年月日();
        this.shikakuHenkoDate = 被保険者.get資格変更年月日();
        this.jushochitokureiTekiyoJiyuCode = 被保険者.get住所地特例適用事由().getCode();
        this.jushochitokureiTekiyoTodokedeDate = 被保険者.get住所地特例適用届出年月日();
        this.jushochitokureiTekiyoDate = 被保険者.get住所地特例適用年月日();
        this.jushochitokureiKaijoJiyuCode = 被保険者.get住所地特例解除事由().getCode();
        this.jushochitokureiKaijoTodokedeDate = 被保険者.get住所地特例解除届出年月日();
        this.jushochitokureiKaijoDate = 被保険者.get住所地特例解除年月日();
        this.jushochitokureiFlag = 被保険者.is住所地特例者();
        this.koikinaiJushochitokureiFlag = 被保険者.is広域内住所地特者();
        this.koikinaiTokureiSochimotoShichosonCd = 被保険者.get広域内住所地特例措置元_市町村コード().getValue();
        this.saikofuKubun = 被保険者.has被保険者証の再交付();
        this.saikofuJiyuCode = 被保険者.get再交付事由().getCode();
    }

    /**
     * @return 市町村コード
     */
    public RString getShichosonCd() {
        return shichosonCd;
    }

    /**
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * @return 識別コード
     */
    public IShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * @return 資格異動区分コード
     */
    public RString getShikakuIdouKubunCode() {
        return shikakuIdouKubunCode;
    }

    /**
     * @return 資格異動届出年月日
     */
    public RDate getShikakuShutokuTodokedeDate() {
        return shikakuShutokuTodokedeDate;
    }

    /**
     * @return 資格取得事由コード
     */
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * @return 資格取得年月日
     */
    public RDate getShikakuShutokuDate() {
        return shikakuShutokuDate;
    }

    /**
     * @return 一号被保険者年齢到達年月日
     */
    public RDate getIchigoHihokenshaNenreiTotatsuDate() {
        return ichigoHihokenshaNenreiTotatsuDate;
    }

    /**
     * @return 被保険者区分コード
     */
    public RString getHihokenshaKubunCode() {
        return hihokenshaKubunCode;
    }

    /**
     * @return 資格喪失事由コード
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * @return 資格喪失届出年月日
     */
    public RDate getShikakuSoshitsuTodokedeDate() {
        return shikakuSoshitsuTodokedeDate;
    }

    /**
     * @return 資格喪失年月日
     */
    public RDate getShikakuSoshitsuDate() {
        return shikakuSoshitsuDate;
    }

    /**
     * @return 資格変更事由コード
     */
    public RString getShikakuHenkoJiyuCode() {
        return shikakuHenkoJiyuCode;
    }

    /**
     * @return 資格変更届出年月日
     */
    public RDate getShikakuHenkoTodokedeDate() {
        return shikakuHenkoTodokedeDate;
    }

    /**
     * @return 資格変更年月日
     */
    public RDate getShikakuHenkoDate() {
        return shikakuHenkoDate;
    }

    /**
     * @return 住所地特例適用事由コード
     */
    public RString getJushochitokureiTekiyoJiyuCode() {
        return jushochitokureiTekiyoJiyuCode;
    }

    /**
     * @return 住所地特例適用届出年月日
     */
    public RDate getJushochitokureiTekiyoTodokedeDate() {
        return jushochitokureiTekiyoTodokedeDate;
    }

    /**
     * @return 住所地特例適用年月日
     */
    public RDate getJushochitokureiTekiyoDate() {
        return jushochitokureiTekiyoDate;
    }

    /**
     * @return 住所地特例解除事由コード
     */
    public RString getJushochitokureiKaijoJiyuCode() {
        return jushochitokureiKaijoJiyuCode;
    }

    /**
     * @return 住所地特例解除届出年月日
     */
    public RDate getJushochitokureiKaijoTodokedeDate() {
        return jushochitokureiKaijoTodokedeDate;
    }

    /**
     * @return 住所地特例解除年月日
     */
    public RDate getJushochitokureiKaijoDate() {
        return jushochitokureiKaijoDate;
    }

    /**
     * @return 住所地特例フラグ
     */
    public boolean isJushochitokureisha() {
        return jushochitokureiFlag;
    }

    /**
     * @return 広域内住所地特例フラグ
     */
    public boolean isKoikinaiJushochitokureisha() {
        return koikinaiJushochitokureiFlag;
    }

    /**
     * @return 広域内特例措置元市町村コード
     */
    public RString getKoikinaiTokureiSochimotoShichosonCd() {
        return koikinaiTokureiSochimotoShichosonCd;
    }

    /**
     * @return 再交付区分
     */
    public boolean hasSaikofu() {
        return saikofuKubun;
    }

    /**
     * @return 再交付事由コード
     */
    public RString getSaikofuJiyuCode() {
        return saikofuJiyuCode;
    }

    /**
     * @param shichosonCd 市町村コード
     */
    public void setShichosonCd(RString shichosonCd) {
        this.shichosonCd = shichosonCd;
    }

    /**
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(IShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * @param shikakuIdouKubunCode 資格異動区分コード
     */
    public void setShikakuIdouKubunCode(RString shikakuIdouKubunCode) {
        this.shikakuIdouKubunCode = shikakuIdouKubunCode;
    }

    /**
     * @param shikakuShutokuTodokedeDate 資格異動届出年月日
     */
    public void setShikakuShutokuTodokedeDate(RDate shikakuShutokuTodokedeDate) {
        this.shikakuShutokuTodokedeDate = shikakuShutokuTodokedeDate;
    }

    /**
     * @param shikakuShutokuJiyuCode 資格取得事由コード
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * @param shikakuShutokuDate 資格取得年月日
     */
    public void setShikakuShutokuDate(RDate shikakuShutokuDate) {
        this.shikakuShutokuDate = shikakuShutokuDate;
    }

    /**
     * @param ichigoHihokenshaNenreiTotatsuDate 一号被保険者年齢到達年月日
     *
     */
    public void setIchigoHihokenshaNenreiTotatsuDate(RDate ichigoHihokenshaNenreiTotatsuDate) {
        this.ichigoHihokenshaNenreiTotatsuDate = ichigoHihokenshaNenreiTotatsuDate;
    }

    /**
     * @param hihokennshaKubunCode 被保険者区分コード
     */
    public void setHihokenshaKubunCode(RString hihokennshaKubunCode) {
        this.hihokenshaKubunCode = hihokennshaKubunCode;
    }

    /**
     * @param shikakuSoshitsuJiyuCode 資格喪失事由コード
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * @param shikakuSoshitsuTodokedeDate 資格喪失届出年月日
     */
    public void setShikakuSoshitsuTodokedeDate(RDate shikakuSoshitsuTodokedeDate) {
        this.shikakuSoshitsuTodokedeDate = shikakuSoshitsuTodokedeDate;
    }

    /**
     * @param shikakuSoshitsuDate 資格喪失年月日
     */
    public void setShikakuSoshitsuDate(RDate shikakuSoshitsuDate) {
        this.shikakuSoshitsuDate = shikakuSoshitsuDate;
    }

    /**
     * @param shikakuHenkoJiyuCode 資格変更事由コード
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        this.shikakuHenkoJiyuCode = shikakuHenkoJiyuCode;
    }

    /**
     * @param shikakuHenkoTodokedeDate 資格変更届出年月日
     */
    public void setShikakuHenkoTodokedeDate(RDate shikakuHenkoTodokedeDate) {
        this.shikakuHenkoTodokedeDate = shikakuHenkoTodokedeDate;
    }

    /**
     * @param shikakuHenkoDate 資格変更年月日
     */
    public void setShikakuHenkoDate(RDate shikakuHenkoDate) {
        this.shikakuHenkoDate = shikakuHenkoDate;
    }

    /**
     * @param jushochitokureiTekiyoJiyuCode 住所地特例適用事由コード set
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        this.jushochitokureiTekiyoJiyuCode = jushochitokureiTekiyoJiyuCode;
    }

    /**
     * @param tekiyoTodokedeDate 住所地特例適用届出年月日
     */
    public void setJushochitokureiTekiyoTodokedeDate(RDate tekiyoTodokedeDate) {
        this.jushochitokureiTekiyoTodokedeDate = tekiyoTodokedeDate;
    }

    /**
     * @param tekiyoDate 住所地特例適用年月日
     */
    public void setJushochitokureiTekiyoDate(RDate tekiyoDate) {
        this.jushochitokureiTekiyoDate = tekiyoDate;
    }

    /**
     * @param jushochitokureiKaijoJiyuCode 住所地特例解除事由コード
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        this.jushochitokureiKaijoJiyuCode = jushochitokureiKaijoJiyuCode;
    }

    /**
     * @param kaijoTodokedeDate 住所地特例解除届出年月日
     */
    public void setJushochitokureiKaijoTodokedeDate(RDate kaijoTodokedeDate) {
        this.jushochitokureiKaijoTodokedeDate = kaijoTodokedeDate;
    }

    /**
     * @param kaijoDate 住所地特例解除年月日
     */
    public void setJushochitokureiKaijoDate(RDate kaijoDate) {
        this.jushochitokureiKaijoDate = kaijoDate;
    }

    /**
     * @param jushochitokureiFlag 住所地特例フラグ
     */
    public void setJushochitokureiFlag(boolean jushochitokureiFlag) {
        this.jushochitokureiFlag = jushochitokureiFlag;
    }

    /**
     * @param koikinaiJushochitokureiFlag 広域内住所地特例フラグ
     */
    public void setKoikinaiJushochitokureiFlag(boolean koikinaiJushochitokureiFlag) {
        this.koikinaiJushochitokureiFlag = koikinaiJushochitokureiFlag;
    }

    /**
     * @param koikinaiTokureiSochimotoShichosonCd 広域内特例措置元市町村コード
     */
    public void setKoikinaiTokureiSochimotoShichosonCd(RString koikinaiTokureiSochimotoShichosonCd) {
        this.koikinaiTokureiSochimotoShichosonCd = koikinaiTokureiSochimotoShichosonCd;
    }

    /**
     * @param saikofuKubun 再交付区分
     */
    public void setSaikofuKubun(boolean saikofuKubun) {
        this.saikofuKubun = saikofuKubun;
    }

    /**
     * @param saikofuJiyuCode 再交付事由コード
     */
    public void setSaikofuJiyuCode(RString saikofuJiyuCode) {
        this.saikofuJiyuCode = saikofuJiyuCode;
    }
}
