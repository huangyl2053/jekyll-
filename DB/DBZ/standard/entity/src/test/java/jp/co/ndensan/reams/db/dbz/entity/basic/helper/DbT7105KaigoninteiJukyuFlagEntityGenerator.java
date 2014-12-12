/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7105KaigoninteiJukyuFlagEntity;

/**
 * 介護認定受給フラグエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7105KaigoninteiJukyuFlagEntityGenerator {

    public static final boolean DEFAULT_基本情報状況フラグ = false;
    public static final boolean DEFAULT_モバイルデータ出力フラグ = false;
    public static final boolean DEFAULT_認定情報提供希望有フラグ = false;
    public static final boolean DEFAULT_介護認定審査会審査順確定フラグ = false;
    public static final boolean DEFAULT_合議体ダミーフラグ = false;
    public static final boolean DEFAULT_合議体精神科医存在フラグ = false;
    public static final boolean DEFAULT_介護認定審査会休会フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7105KaigoninteiJukyuFlagEntityGenerator() {
    }

    public static DbT7105KaigoninteiJukyuFlagEntity createDbT7105KaigoninteiJukyuFlagEntity() {
        DbT7105KaigoninteiJukyuFlagEntity entity = new DbT7105KaigoninteiJukyuFlagEntity();
        entity.setKihonJokyoFlag(DEFAULT_基本情報状況フラグ);
        entity.setMobileDataFlag(DEFAULT_モバイルデータ出力フラグ);
        entity.setNinteiJohoTeikyoKiboAriFlag(DEFAULT_認定情報提供希望有フラグ);
        entity.setShinsakaiShinsajunKakuteiFlag(DEFAULT_介護認定審査会審査順確定フラグ);
        entity.setGogitaiDummyFlag(DEFAULT_合議体ダミーフラグ);
        entity.setGogitaiSeishinkaiFlag(DEFAULT_合議体精神科医存在フラグ);
        entity.setShinsakaiKyukaiFlag(DEFAULT_介護認定審査会休会フラグ);
        return entity;
    }
}
