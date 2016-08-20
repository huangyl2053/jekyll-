package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import java.util.UUID;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 非課税年金対象者テーブルのエンティティクラスです。
 * <br/> 連合会から送付される非課税年金対象者情報と被保険者との関連を管理する
 */
public class DbT4037HikazeNenkinTaishoshaEntity extends DbTableEntityBase<DbT4037HikazeNenkinTaishoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4037HikazeNenkinTaishosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleYear nendo;
    private RString shorikubun;
    private RString taishom;
    private RString kisonenkinno;
    private RString genkisonenkinno;
    private RString nenkincode;
    private RString hihokenshano;
    private RString torokukubun;
    private RString dtrecordkubun;
    private RString dtcitycode;
    private RString dtnenkinhokenshacode;
    private RString dttsuchinaiyocode;
    private RString dtyobi1;
    private RString dtseidocode;
    private RString dtsakuseiymd;
    private RString dtkisonenkinno;
    private RString dtnenkincode;
    private RString dtyobi2;
    private RString dtbirthday;
    private RString dtseibetsu;
    private RString dtkanashimei;
    private RString dtshiftcode1;
    private RString dtkanjishimei;
    private RString dtshiftcode2;
    private RString dtyubinno;
    private RString dtkanajusho;
    private RString dtshiftcode3;
    private RString dtkanjijusho;
    private RString dtshiftcode4;
    private RString dttaishoy;
    private RString dtteiseihyoji;
    private RString dtkakushukubun;
    private RString dtshorikekka;
    private RString dtyobi3;
    private RString dtyobi4;
    private RString dtkingaku1;
    private RString dtkingakuyobi1;
    private RString dtkingakuyobi2;
    private RString dtyobi5;
    private RString dtkyosainenkinshoshokigono;

    /**
     * updateCountのgetメソッドです。
     *
     * @return updateCount
     */
    public int getUpdateCount() {
        return updateCount;
    }

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
     * 年度のgetメソッドです。
     * <br/>
     * <br/>取込、登録各画面で指定した処理年度。処理扱いをした調定年度に相当する
     *
     * @return 年度
     */
    @CheckForNull
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * 年度のsetメソッドです。
     * <br/>
     * <br/>取込、登録各画面で指定した処理年度。処理扱いをした調定年度に相当する
     *
     * @param nendo 年度
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
    }

    /**
     * 処理区分のgetメソッドです。
     * <br/>
     * <br/>11：年次処理、12：月次処理
     *
     * @return 処理区分
     */
    @CheckForNull
    public RString getShorikubun() {
        return shorikubun;
    }

    /**
     * 処理区分のsetメソッドです。
     * <br/>
     * <br/>11：年次処理、12：月次処理
     *
     * @param shorikubun 処理区分
     */
    public void setShorikubun(RString shorikubun) {
        this.shorikubun = shorikubun;
    }

    /**
     * 対象月のgetメソッドです。
     * <br/>
     * <br/>5月、7月～12月を"005", "007"～"012"、翌1月～6月を"101"～"106"のように管理する
     *
     * @return 対象月
     */
    @CheckForNull
    public RString getTaishom() {
        return taishom;
    }

    /**
     * 対象月のsetメソッドです。
     * <br/>
     * <br/>5月、7月～12月を"005", "007"～"012"、翌1月～6月を"101"～"106"のように管理する
     *
     * @param taishom 対象月
     */
    public void setTaishom(RString taishom) {
        this.taishom = taishom;
    }

    /**
     * 基礎年金番号のgetメソッドです。
     * <br/>
     * <br/>DT基礎年金番号と必ず一致する（登録画面の入力項目管理）
     *
     * @return 基礎年金番号
     */
    @CheckForNull
    public RString getKisonenkinno() {
        return kisonenkinno;
    }

    /**
     * 基礎年金番号のsetメソッドです。
     * <br/>
     * <br/>DT基礎年金番号と必ず一致する（登録画面の入力項目管理）
     *
     * @param kisonenkinno 基礎年金番号
     */
    public void setKisonenkinno(RString kisonenkinno) {
        this.kisonenkinno = kisonenkinno;
    }

    /**
     * 現基礎年金番号のgetメソッドです。
     * <br/>
     * <br/>判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @return 現基礎年金番号
     */
    @CheckForNull
    public RString getGenkisonenkinno() {
        return genkisonenkinno;
    }

    /**
     * 現基礎年金番号のsetメソッドです。
     * <br/>
     * <br/>判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @param genkisonenkinno 現基礎年金番号
     */
    public void setGenkisonenkinno(RString genkisonenkinno) {
        this.genkisonenkinno = genkisonenkinno;
    }

    /**
     * 年金コードのgetメソッドです。
     * <br/>
     * <br/>DT年金コードと必ず一致する（登録画面の入力項目管理）、判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @return 年金コード
     */
    @CheckForNull
    public RString getNenkincode() {
        return nenkincode;
    }

    /**
     * 年金コードのsetメソッドです。
     * <br/>
     * <br/>DT年金コードと必ず一致する（登録画面の入力項目管理）、判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @param nenkincode 年金コード
     */
    public void setNenkincode(RString nenkincode) {
        this.nenkincode = nenkincode;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * <br/>
     * <br/>関連付けられた被保険者番号。被保険者と関連づいていない非課税年金対象者情報は、被保険者番号空白
     *
     * @return 被保険者番号
     */
    @CheckForNull
    public RString getHihokenshano() {
        return hihokenshano;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * <br/>
     * <br/>関連付けられた被保険者番号。被保険者と関連づいていない非課税年金対象者情報は、被保険者番号空白
     *
     * @param hihokenshano 被保険者番号
     */
    public void setHihokenshano(RString hihokenshano) {
        this.hihokenshano = hihokenshano;
    }

    /**
     * 登録区分のgetメソッドです。
     * <br/>
     * <br/>1：取込、2：画面登録
     *
     * @return 登録区分
     */
    @CheckForNull
    public RString getTorokukubun() {
        return torokukubun;
    }

    /**
     * 登録区分のsetメソッドです。
     * <br/>
     * <br/>1：取込、2：画面登録
     *
     * @param torokukubun 登録区分
     */
    public void setTorokukubun(RString torokukubun) {
        this.torokukubun = torokukubun;
    }

    /**
     * DTレコード区分のgetメソッドです。
     * <br/>
     * <br/>（以下、"DT"項目は国保連合会から送付の「非課税年金対象者情報」の内容を格納）2：データレコード
     *
     * @return DTレコード区分
     */
    @CheckForNull
    public RString getDtrecordkubun() {
        return dtrecordkubun;
    }

    /**
     * DTレコード区分のsetメソッドです。
     * <br/>
     * <br/>（以下、"DT"項目は国保連合会から送付の「非課税年金対象者情報」の内容を格納）2：データレコード
     *
     * @param dtrecordkubun DTレコード区分
     */
    public void setDtrecordkubun(RString dtrecordkubun) {
        this.dtrecordkubun = dtrecordkubun;
    }

    /**
     * DT市町村コードのgetメソッドです。
     * <br/>
     * <br/>総務省で定められた地方公共団体コード
     *
     * @return DT市町村コード
     */
    @CheckForNull
    public RString getDtcitycode() {
        return dtcitycode;
    }

    /**
     * DT市町村コードのsetメソッドです。
     * <br/>
     * <br/>総務省で定められた地方公共団体コード
     *
     * @param dtcitycode DT市町村コード
     */
    public void setDtcitycode(RString dtcitycode) {
        this.dtcitycode = dtcitycode;
    }

    /**
     * DT年金保険者コードのgetメソッドです。
     * <br/>
     * <br/>年金保険者コード※コードマスタは使用しない。判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @return DT年金保険者コード
     */
    @CheckForNull
    public RString getDtnenkinhokenshacode() {
        return dtnenkinhokenshacode;
    }

    /**
     * DT年金保険者コードのsetメソッドです。
     * <br/>
     * <br/>年金保険者コード※コードマスタは使用しない。判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @param dtnenkinhokenshacode DT年金保険者コード
     */
    public void setDtnenkinhokenshacode(RString dtnenkinhokenshacode) {
        this.dtnenkinhokenshacode = dtnenkinhokenshacode;
    }

    /**
     * DT通知内容コードのgetメソッドです。
     * <br/>
     * <br/>93：補足給付初回回付（年次）情報、94：補足給付初回回付（月次）情報
     *
     * @return DT通知内容コード
     */
    @CheckForNull
    public RString getDttsuchinaiyocode() {
        return dttsuchinaiyocode;
    }

    /**
     * DT通知内容コードのsetメソッドです。
     * <br/>
     * <br/>93：補足給付初回回付（年次）情報、94：補足給付初回回付（月次）情報
     *
     * @param dttsuchinaiyocode DT通知内容コード
     */
    public void setDttsuchinaiyocode(RString dttsuchinaiyocode) {
        this.dttsuchinaiyocode = dttsuchinaiyocode;
    }

    /**
     * DT予備１のgetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @return DT予備１
     */
    @CheckForNull
    public RString getDtyobi1() {
        return dtyobi1;
    }

    /**
     * DT予備１のsetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @param dtyobi1 DT予備１
     */
    public void setDtyobi1(RString dtyobi1) {
        this.dtyobi1 = dtyobi1;
    }

    /**
     * DT制度コードのgetメソッドです。
     * <br/>
     * <br/>5：介護（補足給付）
     *
     * @return DT制度コード
     */
    @CheckForNull
    public RString getDtseidocode() {
        return dtseidocode;
    }

    /**
     * DT制度コードのsetメソッドです。
     * <br/>
     * <br/>5：介護（補足給付）
     *
     * @param dtseidocode DT制度コード
     */
    public void setDtseidocode(RString dtseidocode) {
        this.dtseidocode = dtseidocode;
    }

    /**
     * DT作成年月日のgetメソッドです。
     * <br/>
     * <br/>レコード作成時の年月日。同一年金のが存在する場合、DT作成年月日がより新しいものを勘案する
     *
     * @return DT作成年月日
     */
    @CheckForNull
    public RString getDtsakuseiymd() {
        return dtsakuseiymd;
    }

    /**
     * DT作成年月日のsetメソッドです。
     * <br/>
     * <br/>レコード作成時の年月日。同一年金のが存在する場合、DT作成年月日がより新しいものを勘案する
     *
     * @param dtsakuseiymd DT作成年月日
     */
    public void setDtsakuseiymd(RString dtsakuseiymd) {
        this.dtsakuseiymd = dtsakuseiymd;
    }

    /**
     * DT基礎年金番号のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の基礎年金番号
     *
     * @return DT基礎年金番号
     */
    @CheckForNull
    public RString getDtkisonenkinno() {
        return dtkisonenkinno;
    }

    /**
     * DT基礎年金番号のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の基礎年金番号
     *
     * @param dtkisonenkinno DT基礎年金番号
     */
    public void setDtkisonenkinno(RString dtkisonenkinno) {
        this.dtkisonenkinno = dtkisonenkinno;
    }

    /**
     * DT年金コードのgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の"年金種別"2桁-"年金区分コード１"1桁-"年金区分コード２"1桁
     * <br/>※コードマスタは使用しない。
     *
     * @return DT年金コード
     */
    @CheckForNull
    public RString getDtnenkincode() {
        return dtnenkincode;
    }

    /**
     * DT年金コードのsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の"年金種別"2桁-"年金区分コード１"1桁-"年金区分コード２"1桁
     * <br/>※コードマスタは使用しない。
     *
     * @param dtnenkincode DT年金コード
     */
    public void setDtnenkincode(RString dtnenkincode) {
        this.dtnenkincode = dtnenkincode;
    }

    /**
     * DT予備２のgetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @return DT予備２
     */
    @CheckForNull
    public RString getDtyobi2() {
        return dtyobi2;
    }

    /**
     * DT予備２のsetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @param dtyobi2 DT予備２
     */
    public void setDtyobi2(RString dtyobi2) {
        this.dtyobi2 = dtyobi2;
    }

    /**
     * DT生年月日のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の生年月日
     *
     * @return DT生年月日
     */
    @CheckForNull
    public RString getDtbirthday() {
        return dtbirthday;
    }

    /**
     * DT生年月日のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の生年月日
     *
     * @param dtbirthday DT生年月日
     */
    public void setDtbirthday(RString dtbirthday) {
        this.dtbirthday = dtbirthday;
    }

    /**
     * DT性別のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の性別コード　1：男、2：女
     *
     * @return DT性別
     */
    @CheckForNull
    public RString getDtseibetsu() {
        return dtseibetsu;
    }

    /**
     * DT性別のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の性別コード　1：男、2：女
     *
     * @param dtseibetsu DT性別
     */
    public void setDtseibetsu(RString dtseibetsu) {
        this.dtseibetsu = dtseibetsu;
    }

    /**
     * DTカナ氏名のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者のカナ氏名
     * <br/>（カナ文字については、カナ大文字のみが設定される）
     *
     * @return DTカナ氏名
     */
    @CheckForNull
    public RString getDtkanashimei() {
        return dtkanashimei;
    }

    /**
     * DTカナ氏名のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者のカナ氏名
     * <br/>（カナ文字については、カナ大文字のみが設定される）
     *
     * @param dtkanashimei DTカナ氏名
     */
    public void setDtkanashimei(RString dtkanashimei) {
        this.dtkanashimei = dtkanashimei;
    }

    /**
     * DTシフトコード１のgetメソッドです。
     * <br/>
     * <br/>漢字シフトコード：16進"1B2442"
     *
     * @return DTシフトコード１
     */
    @CheckForNull
    public RString getDtshiftcode1() {
        return dtshiftcode1;
    }

    /**
     * DTシフトコード１のsetメソッドです。
     * <br/>
     * <br/>漢字シフトコード：16進"1B2442"
     *
     * @param dtshiftcode1 DTシフトコード１
     */
    public void setDtshiftcode1(RString dtshiftcode1) {
        this.dtshiftcode1 = dtshiftcode1;
    }

    /**
     * DT漢字氏名のgetメソッドです。
     * <br/>
     * <br/>非課税年金の漢字氏名
     *
     * @return DT漢字氏名
     */
    @CheckForNull
    public RString getDtkanjishimei() {
        return dtkanjishimei;
    }

    /**
     * DT漢字氏名のsetメソッドです。
     * <br/>
     * <br/>非課税年金の漢字氏名
     *
     * @param dtkanjishimei DT漢字氏名
     */
    public void setDtkanjishimei(RString dtkanjishimei) {
        this.dtkanjishimei = dtkanjishimei;
    }

    /**
     * DTシフトコード２のgetメソッドです。
     * <br/>
     * <br/>カナシフトコード：16進"1B284A"
     *
     * @return DTシフトコード２
     */
    @CheckForNull
    public RString getDtshiftcode2() {
        return dtshiftcode2;
    }

    /**
     * DTシフトコード２のsetメソッドです。
     * <br/>
     * <br/>カナシフトコード：16進"1B284A"
     *
     * @param dtshiftcode2 DTシフトコード２
     */
    public void setDtshiftcode2(RString dtshiftcode2) {
        this.dtshiftcode2 = dtshiftcode2;
    }

    /**
     * DT郵便番号のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の郵便番号
     *
     * @return DT郵便番号
     */
    @CheckForNull
    public RString getDtyubinno() {
        return dtyubinno;
    }

    /**
     * DT郵便番号のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の郵便番号
     *
     * @param dtyubinno DT郵便番号
     */
    public void setDtyubinno(RString dtyubinno) {
        this.dtyubinno = dtyubinno;
    }

    /**
     * DTカナ住所のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者のカナ住所
     * <br/>島しょ以外の市町村については、都道府県名は省略される。
     * <br/>（カナ文字については、カナ大文字のみが設定される）
     *
     * @return DTカナ住所
     */
    @CheckForNull
    public RString getDtkanajusho() {
        return dtkanajusho;
    }

    /**
     * DTカナ住所のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者のカナ住所
     * <br/>島しょ以外の市町村については、都道府県名は省略される。
     * <br/>（カナ文字については、カナ大文字のみが設定される）
     *
     * @param dtkanajusho DTカナ住所
     */
    public void setDtkanajusho(RString dtkanajusho) {
        this.dtkanajusho = dtkanajusho;
    }

    /**
     * DTシフトコード３のgetメソッドです。
     * <br/>
     * <br/>漢字シフトコード：16進"1B2442"
     *
     * @return DTシフトコード３
     */
    @CheckForNull
    public RString getDtshiftcode3() {
        return dtshiftcode3;
    }

    /**
     * DTシフトコード３のsetメソッドです。
     * <br/>
     * <br/>漢字シフトコード：16進"1B2442"
     *
     * @param dtshiftcode3 DTシフトコード３
     */
    public void setDtshiftcode3(RString dtshiftcode3) {
        this.dtshiftcode3 = dtshiftcode3;
    }

    /**
     * DT漢字住所のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の漢字住所
     * <br/>島しょ以外の市町村については、都道府県名は省略される。
     *
     * @return DT漢字住所
     */
    @CheckForNull
    public RString getDtkanjijusho() {
        return dtkanjijusho;
    }

    /**
     * DT漢字住所のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の漢字住所
     * <br/>島しょ以外の市町村については、都道府県名は省略される。
     *
     * @param dtkanjijusho DT漢字住所
     */
    public void setDtkanjijusho(RString dtkanjijusho) {
        this.dtkanjijusho = dtkanjijusho;
    }

    /**
     * DTシフトコード４のgetメソッドです。
     * <br/>
     * <br/>カナシフトコード：16進"1B284A"
     *
     * @return DTシフトコード４
     */
    @CheckForNull
    public RString getDtshiftcode4() {
        return dtshiftcode4;
    }

    /**
     * DTシフトコード４のsetメソッドです。
     * <br/>
     * <br/>カナシフトコード：16進"1B284A"
     *
     * @param dtshiftcode4 DTシフトコード４
     */
    public void setDtshiftcode4(RString dtshiftcode4) {
        this.dtshiftcode4 = dtshiftcode4;
    }

    /**
     * DT対象年のgetメソッドです。
     * <br/>
     * <br/>計単対象年（西暦）。年金の受給年を表し、負担限度額認定には、認定年度前年分を勘案する。判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @return DT対象年
     */
    @CheckForNull
    public RString getDttaishoy() {
        return dttaishoy;
    }

    /**
     * DT対象年のsetメソッドです。
     * <br/>
     * <br/>計単対象年（西暦）。年金の受給年を表し、負担限度額認定には、認定年度前年分を勘案する。判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     *
     * @param dttaishoy DT対象年
     */
    public void setDttaishoy(RString dttaishoy) {
        this.dttaishoy = dttaishoy;
    }

    /**
     * DT訂正表示のgetメソッドです。
     * <br/>
     * <br/>0：初回回付（年次／新裁分）、1：月次回付（遡及改定分）
     *
     * @return DT訂正表示
     */
    @CheckForNull
    public RString getDtteiseihyoji() {
        return dtteiseihyoji;
    }

    /**
     * DT訂正表示のsetメソッドです。
     * <br/>
     * <br/>0：初回回付（年次／新裁分）、1：月次回付（遡及改定分）
     *
     * @param dtteiseihyoji DT訂正表示
     */
    public void setDtteiseihyoji(RString dtteiseihyoji) {
        this.dtteiseihyoji = dtteiseihyoji;
    }

    /**
     * DT各種区分のgetメソッドです。
     * <br/>
     * <br/>01：新規者、02：前年度継続者
     *
     * @return DT各種区分
     */
    @CheckForNull
    public RString getDtkakushukubun() {
        return dtkakushukubun;
    }

    /**
     * DT各種区分のsetメソッドです。
     * <br/>
     * <br/>01：新規者、02：前年度継続者
     *
     * @param dtkakushukubun DT各種区分
     */
    public void setDtkakushukubun(RString dtkakushukubun) {
        this.dtkakushukubun = dtkakushukubun;
    }

    /**
     * DT処理結果のgetメソッドです。
     * <br/>
     * <br/>00：初期値、01：受給権の失権（死亡失権は含まない）、02：差止・一時停止・停止
     *
     * @return DT処理結果
     */
    @CheckForNull
    public RString getDtshorikekka() {
        return dtshorikekka;
    }

    /**
     * DT処理結果のsetメソッドです。
     * <br/>
     * <br/>00：初期値、01：受給権の失権（死亡失権は含まない）、02：差止・一時停止・停止
     *
     * @param dtshorikekka DT処理結果
     */
    public void setDtshorikekka(RString dtshorikekka) {
        this.dtshorikekka = dtshorikekka;
    }

    /**
     * DT予備３のgetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @return DT予備３
     */
    @CheckForNull
    public RString getDtyobi3() {
        return dtyobi3;
    }

    /**
     * DT予備３のsetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @param dtyobi3 DT予備３
     */
    public void setDtyobi3(RString dtyobi3) {
        this.dtyobi3 = dtyobi3;
    }

    /**
     * DT予備４のgetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @return DT予備４
     */
    @CheckForNull
    public RString getDtyobi4() {
        return dtyobi4;
    }

    /**
     * DT予備４のsetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @param dtyobi4 DT予備４
     */
    public void setDtyobi4(RString dtyobi4) {
        this.dtyobi4 = dtyobi4;
    }

    /**
     * DT金額１のgetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の非課税年金額（右詰、11桁左ゼロ埋め）
     *
     * @return DT金額１
     */
    @CheckForNull
    public RString getDtkingaku1() {
        return dtkingaku1;
    }

    /**
     * DT金額１のsetメソッドです。
     * <br/>
     * <br/>非課税年金対象者の非課税年金額（右詰、11桁左ゼロ埋め）
     *
     * @param dtkingaku1 DT金額１
     */
    public void setDtkingaku1(RString dtkingaku1) {
        this.dtkingaku1 = dtkingaku1;
    }

    /**
     * DT金額予備１のgetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @return DT金額予備１
     */
    @CheckForNull
    public RString getDtkingakuyobi1() {
        return dtkingakuyobi1;
    }

    /**
     * DT金額予備１のsetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @param dtkingakuyobi1 DT金額予備１
     */
    public void setDtkingakuyobi1(RString dtkingakuyobi1) {
        this.dtkingakuyobi1 = dtkingakuyobi1;
    }

    /**
     * DT金額予備２のgetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @return DT金額予備２
     */
    @CheckForNull
    public RString getDtkingakuyobi2() {
        return dtkingakuyobi2;
    }

    /**
     * DT金額予備２のsetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @param dtkingakuyobi2 DT金額予備２
     */
    public void setDtkingakuyobi2(RString dtkingakuyobi2) {
        this.dtkingakuyobi2 = dtkingakuyobi2;
    }

    /**
     * DT予備５のgetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @return DT予備５
     */
    @CheckForNull
    public RString getDtyobi5() {
        return dtyobi5;
    }

    /**
     * DT予備５のsetメソッドです。
     * <br/>
     * <br/>オールスペース（半角）
     *
     * @param dtyobi5 DT予備５
     */
    public void setDtyobi5(RString dtyobi5) {
        this.dtyobi5 = dtyobi5;
    }

    /**
     * DT共済年金証書記号番号のgetメソッドです。
     * <br/>
     * <br/>共済年金記号番号。共済組合以外はオールスペース（半角）。農林原簿移管者は共通農林整理番号
     *
     * @return DT共済年金証書記号番号
     */
    @CheckForNull
    public RString getDtkyosainenkinshoshokigono() {
        return dtkyosainenkinshoshokigono;
    }

    /**
     * DT共済年金証書記号番号のsetメソッドです。
     * <br/>
     * <br/>共済年金記号番号。共済組合以外はオールスペース（半角）。農林原簿移管者は共通農林整理番号
     *
     * @param dtkyosainenkinshoshokigono DT共済年金証書記号番号
     */
    public void setDtkyosainenkinshoshokigono(RString dtkyosainenkinshoshokigono) {
        this.dtkyosainenkinshoshokigono = dtkyosainenkinshoshokigono;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4037HikazeNenkinTaishoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT4037HikazeNenkinTaishoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4037HikazeNenkinTaishoshaEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4037HikazeNenkinTaishoshaEntity entity) {
        this.nendo = entity.nendo;
        this.shorikubun = entity.shorikubun;
        this.taishom = entity.taishom;
        this.kisonenkinno = entity.kisonenkinno;
        this.genkisonenkinno = entity.genkisonenkinno;
        this.nenkincode = entity.nenkincode;
        this.hihokenshano = entity.hihokenshano;
        this.torokukubun = entity.torokukubun;
        this.dtrecordkubun = entity.dtrecordkubun;
        this.dtcitycode = entity.dtcitycode;
        this.dtnenkinhokenshacode = entity.dtnenkinhokenshacode;
        this.dttsuchinaiyocode = entity.dttsuchinaiyocode;
        this.dtyobi1 = entity.dtyobi1;
        this.dtseidocode = entity.dtseidocode;
        this.dtsakuseiymd = entity.dtsakuseiymd;
        this.dtkisonenkinno = entity.dtkisonenkinno;
        this.dtnenkincode = entity.dtnenkincode;
        this.dtyobi2 = entity.dtyobi2;
        this.dtbirthday = entity.dtbirthday;
        this.dtseibetsu = entity.dtseibetsu;
        this.dtkanashimei = entity.dtkanashimei;
        this.dtshiftcode1 = entity.dtshiftcode1;
        this.dtkanjishimei = entity.dtkanjishimei;
        this.dtshiftcode2 = entity.dtshiftcode2;
        this.dtyubinno = entity.dtyubinno;
        this.dtkanajusho = entity.dtkanajusho;
        this.dtshiftcode3 = entity.dtshiftcode3;
        this.dtkanjijusho = entity.dtkanjijusho;
        this.dtshiftcode4 = entity.dtshiftcode4;
        this.dttaishoy = entity.dttaishoy;
        this.dtteiseihyoji = entity.dtteiseihyoji;
        this.dtkakushukubun = entity.dtkakushukubun;
        this.dtshorikekka = entity.dtshorikekka;
        this.dtyobi3 = entity.dtyobi3;
        this.dtyobi4 = entity.dtyobi4;
        this.dtkingaku1 = entity.dtkingaku1;
        this.dtkingakuyobi1 = entity.dtkingakuyobi1;
        this.dtkingakuyobi2 = entity.dtkingakuyobi2;
        this.dtyobi5 = entity.dtyobi5;
        this.dtkyosainenkinshoshokigono = entity.dtkyosainenkinshoshokigono;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, shorikubun, taishom, kisonenkinno, genkisonenkinno, nenkincode, hihokenshano, torokukubun, dtrecordkubun, dtcitycode, dtnenkinhokenshacode, dttsuchinaiyocode, dtyobi1, dtseidocode, dtsakuseiymd, dtkisonenkinno, dtnenkincode, dtyobi2, dtbirthday, dtseibetsu, dtkanashimei, dtshiftcode1, dtkanjishimei, dtshiftcode2, dtyubinno, dtkanajusho, dtshiftcode3, dtkanjijusho, dtshiftcode4, dttaishoy, dtteiseihyoji, dtkakushukubun, dtshorikekka, dtyobi3, dtyobi4, dtkingaku1, dtkingakuyobi1, dtkingakuyobi2, dtyobi5, dtkyosainenkinshoshokigono);
    }

// </editor-fold>
}
