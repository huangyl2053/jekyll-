/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為損害賠償金受領エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("Data");
    public static final RString DEFAULT_第三者行為求償請求番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_入金確認年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_領収年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_領収金額 = new Decimal(0);
    public static final RString DEFAULT_過不足金有無 = new RString("Data");
    public static final Decimal DEFAULT_過不足額 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator() {
    }

    public static DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity createDbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity() {
        DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity = new DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setKyushoSeikyuNo(DEFAULT_第三者行為求償請求番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setNyukinKakuninYMD(DEFAULT_入金確認年月日);
        entity.setRyoshuYMD(DEFAULT_領収年月日);
        entity.setRyoshuKingaku(DEFAULT_領収金額);
        entity.setMabusokuKinUMU(DEFAULT_過不足金有無);
        entity.setKabusokuGaku(DEFAULT_過不足額);
        return entity;
    }
}
