/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御共通エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7065ChohyoSeigyoKyotsuEntityGenerator {

    public static final SubGyomuCode DEFAULT_サブ業務コード = new SubGyomuCode("DBZ");
    public static final ReportId DEFAULT_帳票分類ID = new ReportId("0000000001");
    public static final RString DEFAULT_帳票分類名称 = new RString("Data");
    public static final RString DEFAULT_住所編集区分 = new RString("Data");
    public static final boolean DEFAULT_住所編集都道府県名表示有無 = false;
    public static final boolean DEFAULT_住所編集郡名表示有無 = false;
    public static final boolean DEFAULT_住所編集市町村名表示有無 = false;
    public static final RString DEFAULT_住所編集町域編集方法 = new RString("Data");
    public static final boolean DEFAULT_住所編集方書表示有無 = false;
    public static final boolean DEFAULT_世帯主表示有無 = false;
    public static final boolean DEFAULT_カスタマバーコード使用有無 = false;
    public static final RString DEFAULT_カスタマバーコード変換エラー編集方法 = new RString("Data");
    public static final RString DEFAULT_外部帳票文字切れ制御 = new RString("Data");
    public static final RString DEFAULT_内部帳票文字切れ制御 = new RString("Data");
    public static final RString DEFAULT_文字切れ分離制御 = new RString("Data");
    public static final RString DEFAULT_定型文文字サイズ = new RString("Data");
    public static final boolean DEFAULT_口座マスク有無 = false;
    public static final RString DEFAULT_口座名義人カナ優先区分 = new RString("Data");
    public static final boolean DEFAULT_代行プリント有無 = false;
    public static final RString DEFAULT_地区表示1 = new RString("Data");
    public static final RString DEFAULT_地区表示2 = new RString("Data");
    public static final RString DEFAULT_地区表示3 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7065ChohyoSeigyoKyotsuEntityGenerator() {
    }

    public static DbT7065ChohyoSeigyoKyotsuEntity createDbT7065ChohyoSeigyoKyotsuEntity() {
        DbT7065ChohyoSeigyoKyotsuEntity entity = new DbT7065ChohyoSeigyoKyotsuEntity();
        entity.setSubGyomuCode(DEFAULT_サブ業務コード);
        entity.setChohyoBunruiID(DEFAULT_帳票分類ID);
        entity.setChohyoBunruiMeisho(DEFAULT_帳票分類名称);
        entity.setJushoHenshuKubun(DEFAULT_住所編集区分);
        entity.setJushoHenshuTodoufukenMeiHyojiUmu(DEFAULT_住所編集都道府県名表示有無);
        entity.setJushoHenshuGunMeiHyojiUmu(DEFAULT_住所編集郡名表示有無);
        entity.setJushoHenshuShichosonMeiHyojiUmu(DEFAULT_住所編集市町村名表示有無);
        entity.setJushoHenshuChoikiHenshuHoho(DEFAULT_住所編集町域編集方法);
        entity.setJushoHenshuKatagakiHyojiUmu(DEFAULT_住所編集方書表示有無);
        entity.setSetainushiHyojiUmu(DEFAULT_世帯主表示有無);
        entity.setCustomerBarCodeShiyoUmu(DEFAULT_カスタマバーコード使用有無);
        entity.setCustomerBarCodeHenkanErrHenshuHoho(DEFAULT_カスタマバーコード変換エラー編集方法);
        entity.setGaibuChohyoMojigireSeigyo(DEFAULT_外部帳票文字切れ制御);
        entity.setNaibuChohyoMojigireSeigyo(DEFAULT_内部帳票文字切れ制御);
        entity.setMojigireBunriSeigyo(DEFAULT_文字切れ分離制御);
        entity.setTeikeibunMojiSize(DEFAULT_定型文文字サイズ);
        entity.setKozaMaskUmu(DEFAULT_口座マスク有無);
        entity.setKozaMeigininKanaYusenKubun(DEFAULT_口座名義人カナ優先区分);
        entity.setDaikoPrintUmu(DEFAULT_代行プリント有無);
        entity.setChikuHyoji1(DEFAULT_地区表示1);
        entity.setChikuHyoji2(DEFAULT_地区表示2);
        entity.setChikuHyoji3(DEFAULT_地区表示3);
        return entity;
    }
}
