/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御共通コントロールエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7066ChohyoSeigyoKyotsuControlEntityGenerator {

    public static final SubGyomuCode DEFAULT_サブ業務コード = new SubGyomuCode("DBZ");
    public static final ReportId DEFAULT_帳票分類ID = new ReportId("0000000001");
    public static final boolean DEFAULT_共通画面使用有無 = false;
    public static final RString DEFAULT_文書番号使用区分 = new RString("Data");
    public static final RString DEFAULT_通知書定型文使用区分 = new RString("Data");
    public static final RString DEFAULT_認証者使用区分 = new RString("Data");
    public static final RString DEFAULT_帳票出力順使用区分 = new RString("Data");
    public static final RString DEFAULT_帳票出力順表示方法 = new RString("Data");
    public static final RString DEFAULT_介護問合せ先使用区分 = new RString("Data");
    public static final RString DEFAULT_住所編集使用区分 = new RString("Data");
    public static final RString DEFAULT_世帯主表示使用区分 = new RString("Data");
    public static final RString DEFAULT_カスタマバーコード使用区分 = new RString("Data");
    public static final RString DEFAULT_外部帳票文字切れ制御使用区分 = new RString("Data");
    public static final RString DEFAULT_内部帳票文字切れ制御使用区分 = new RString("Data");
    public static final RString DEFAULT_文字切れ分離制御使用区分 = new RString("Data");
    public static final RString DEFAULT_定型文文字サイズ使用区分 = new RString("Data");
    public static final RString DEFAULT_口座マスク使用区分 = new RString("Data");
    public static final RString DEFAULT_口座名義人カナ優先使用区分 = new RString("Data");
    public static final RString DEFAULT_代行プリント使用区分 = new RString("Data");
    public static final RString DEFAULT_地区表示使用区分 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7066ChohyoSeigyoKyotsuControlEntityGenerator() {
    }

    public static DbT7066ChohyoSeigyoKyotsuControlEntity createDbT7066ChohyoSeigyoKyotsuControlEntity() {
        DbT7066ChohyoSeigyoKyotsuControlEntity entity = new DbT7066ChohyoSeigyoKyotsuControlEntity();
        entity.setSubGyomuCode(DEFAULT_サブ業務コード);
        entity.setChohyoBunruiID(DEFAULT_帳票分類ID);
        entity.setKyotsuGamenShiyoUmu(DEFAULT_共通画面使用有無);
        entity.setBunshoNoShiyoKubun(DEFAULT_文書番号使用区分);
        entity.setTsuchishoTeikeibunShiyoKubun(DEFAULT_通知書定型文使用区分);
        entity.setNinshoshaShiyoKubun(DEFAULT_認証者使用区分);
        entity.setChohyoShuturyokujunShiyoKubun(DEFAULT_帳票出力順使用区分);
        entity.setChohyoShuturyokujunHyojiHohho(DEFAULT_帳票出力順表示方法);
        entity.setKaigoToiawasesakiShiyoKubun(DEFAULT_介護問合せ先使用区分);
        entity.setJushoHenshuShiyoKubun(DEFAULT_住所編集使用区分);
        entity.setSetainushiHyojiShiyoKubun(DEFAULT_世帯主表示使用区分);
        entity.setCustomerBarCodeShiyoKubun(DEFAULT_カスタマバーコード使用区分);
        entity.setGaibuChohyoMojigireSeigyoShiyoKubun(DEFAULT_外部帳票文字切れ制御使用区分);
        entity.setNaibuChohyoMojigireSeigyoShiyoKubun(DEFAULT_内部帳票文字切れ制御使用区分);
        entity.setMojigireBunriSeigyoShiyoKubun(DEFAULT_文字切れ分離制御使用区分);
        entity.setTeikeibunMojiSizeShiyoKubun(DEFAULT_定型文文字サイズ使用区分);
        entity.setKozaMaskShiyoKubun(DEFAULT_口座マスク使用区分);
        entity.setKozaMeigininKanaYusenShiyoKubun(DEFAULT_口座名義人カナ優先使用区分);
        entity.setDaikoPrintShiyoKubun(DEFAULT_代行プリント使用区分);
        entity.setChikuhyojiShiyoKubun(DEFAULT_地区表示使用区分);
        return entity;
    }
}
