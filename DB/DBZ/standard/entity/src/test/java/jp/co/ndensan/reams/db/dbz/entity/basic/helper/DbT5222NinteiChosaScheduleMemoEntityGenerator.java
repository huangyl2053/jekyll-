/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュールメモ情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5222NinteiChosaScheduleMemoEntityGenerator {

    public static final FlexibleDate DEFAULT_メモ年月日 = new FlexibleDate("20141030");
    public static final Code DEFAULT_調査地区コード = new Code("01");
    public static final Code DEFAULT_メモ区分 = new Code("01");
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_メモ指定調査地区コード = new Code("01");
    public static final RString DEFAULT_作成者 = new RString("名称");
    public static final Code DEFAULT_メモ重要度 = new Code("01");
    public static final RString DEFAULT_メモ内容 = new RString("名称");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5222NinteiChosaScheduleMemoEntityGenerator() {
    }

    public static DbT5222NinteiChosaScheduleMemoEntity createDbT5222NinteiChosaScheduleMemoEntity() {
        DbT5222NinteiChosaScheduleMemoEntity entity = new DbT5222NinteiChosaScheduleMemoEntity();
        entity.setMemoYMD(DEFAULT_メモ年月日);
        entity.setChosachikucode(DEFAULT_調査地区コード);
        entity.setMemoKubun(DEFAULT_メモ区分);
        entity.setRemban(DEFAULT_連番);
        entity.setMemoShiteiChosaChikuCode(DEFAULT_メモ指定調査地区コード);
        entity.setSakuseisha(DEFAULT_作成者);
        entity.setMemoPriority(DEFAULT_メモ重要度);
        entity.setMemoNaiyo(DEFAULT_メモ内容);
        return entity;
    }
}
