/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5221NinteichosaScheduleEntityGenerator {

    public static final FlexibleDate DEFAULT_認定調査予定年月日 = new FlexibleDate("20150402");
    public static final RString DEFAULT_認定調査予定開始時間 = new RString("1");
    public static final RString DEFAULT_認定調査予定終了時間 = new RString("1");
    public static final Code DEFAULT_認定調査時間枠 = new Code("1");
    public static final Code DEFAULT_調査地区コード = new Code("1");
    public static final RString DEFAULT_認定調査委託先コード = new RString("1");
    public static final RString DEFAULT_認定調査員コード = new RString("1");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final Code DEFAULT_予約状況 = new Code("1");
    public static final boolean DEFAULT_予約可能フラグ = false;
    public static final RString DEFAULT_備考 = new RString("1");
    public static final RString DEFAULT_場所 = new RString("1");
    public static final RString DEFAULT_駐車場 = new RString("1");
    public static final RString DEFAULT_立会人１ = new RString("1");
    public static final TelNo DEFAULT_連絡先１ = new TelNo("1234567890");
    public static final RString DEFAULT_立会人２ = new RString("1");
    public static final TelNo DEFAULT_連絡先２ = new TelNo("1234567890");
    public static final RString DEFAULT_対象者メモ = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5221NinteichosaScheduleEntityGenerator() {
    }

    public static DbT5221NinteichosaScheduleEntity createDbT5221NinteichosaScheduleEntity() {
        DbT5221NinteichosaScheduleEntity entity = new DbT5221NinteichosaScheduleEntity();
        entity.setNinteiChosaYoteiYMD(DEFAULT_認定調査予定年月日);
        entity.setNinteiChosaYoteiKaishiTime(DEFAULT_認定調査予定開始時間);
        entity.setNinteiChosaYoteiShuryoTime(DEFAULT_認定調査予定終了時間);
        entity.setNinteiChosaJikanWaku(DEFAULT_認定調査時間枠);
        entity.setChosaChikuCode(DEFAULT_調査地区コード);
        entity.setNinteiChosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setNinteiChosainCode(DEFAULT_認定調査員コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setYoyakuJokyo(DEFAULT_予約状況);
        entity.setYoyakuKaoFlag(DEFAULT_予約可能フラグ);
        entity.setBiko(DEFAULT_備考);
        entity.setBasho(DEFAULT_場所);
        entity.setChushajo(DEFAULT_駐車場);
        entity.setTachiainin1(DEFAULT_立会人１);
        entity.setRenrakusaki1(DEFAULT_連絡先１);
        entity.setTachiainin2(DEFAULT_立会人２);
        entity.setRenrakusaki2(DEFAULT_連絡先２);
        entity.setTaishoshaMemo(DEFAULT_対象者メモ);
        return entity;
    }
}
