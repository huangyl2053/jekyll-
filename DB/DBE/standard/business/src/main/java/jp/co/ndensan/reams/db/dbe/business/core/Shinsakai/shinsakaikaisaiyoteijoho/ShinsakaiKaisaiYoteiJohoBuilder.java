/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho.ShinsakaiOnseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiKaisaiYoteiJoho}の編集を行うビルダークラスです。
 */
public class ShinsakaiKaisaiYoteiJohoBuilder {

    private final DbT5501ShinsakaiKaisaiYoteiJohoEntity entity;
    private final ShinsakaiKaisaiYoteiJohoIdentifier id;
    private final Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiWariateJoho;
    private final Models<ShinsakaiWariateIinJohoIdentifier, ShinsakaiWariateIinJoho> shinsakaiWariateIinJoho;
    private final Models<ShinsakaiOnseiJohoIdentifier, ShinsakaiOnseiJoho> shinsakaiOnseiJoho;
    private final Models<ShinsakaiKaisaiKekkaJohoIdentifier, ShinsakaiKaisaiKekkaJoho> shinsakaiKaisaiKekkaJoho;

    /**
     * {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}より{@link ShinsakaiKaisaiYoteiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}
     * @param id {@link ShinsakaiKaisaiYoteiJohoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ShinsakaiKaisaiYoteiJohoBuilder(
            DbT5501ShinsakaiKaisaiYoteiJohoEntity entity,
            ShinsakaiKaisaiYoteiJohoIdentifier id,
            Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiWariateJoho,
            Models<ShinsakaiWariateIinJohoIdentifier, ShinsakaiWariateIinJoho> shinsakaiWariateIinJoho,
            Models<ShinsakaiOnseiJohoIdentifier, ShinsakaiOnseiJoho> shinsakaiOnseiJoho,
            Models<ShinsakaiKaisaiKekkaJohoIdentifier, ShinsakaiKaisaiKekkaJoho> shinsakaiKaisaiKekkaJoho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho.clone();
        this.shinsakaiWariateIinJoho = shinsakaiWariateIinJoho.clone();
        this.shinsakaiOnseiJoho = shinsakaiOnseiJoho.clone();
        this.shinsakaiKaisaiKekkaJoho = shinsakaiKaisaiKekkaJoho.clone();
    }

    /**
     * 介護認定審査会開催番号を設定します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会開催番号(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        return this;
    }

    /**
     * 介護認定審査会開催予定年月日を設定します。
     *
     * @param 介護認定審査会開催予定年月日 介護認定審査会開催予定年月日
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会開催予定年月日(FlexibleDate 介護認定審査会開催予定年月日) {
        requireNonNull(介護認定審査会開催予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定年月日"));
        entity.setShinsakaiKaisaiYoteiYMD(介護認定審査会開催予定年月日);
        return this;
    }

    /**
     * 介護認定審査会開始予定時刻を設定します。
     *
     * @param 介護認定審査会開始予定時刻 介護認定審査会開始予定時刻
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会開始予定時刻(RString 介護認定審査会開始予定時刻) {
        requireNonNull(介護認定審査会開始予定時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開始予定時刻"));
        entity.setShinsakaiKaishiYoteiTime(介護認定審査会開始予定時刻);
        return this;
    }

    /**
     * 介護認定審査会終了予定時刻を設定します。
     *
     * @param 介護認定審査会終了予定時刻 介護認定審査会終了予定時刻
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会終了予定時刻(RString 介護認定審査会終了予定時刻) {
        requireNonNull(介護認定審査会終了予定時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会終了予定時刻"));
        entity.setShinsakaiShuryoYoteiTime(介護認定審査会終了予定時刻);
        return this;
    }

    /**
     * 介護認定審査会開催予定場所コードを設定します。
     *
     * @param 介護認定審査会開催予定場所コード 介護認定審査会開催予定場所コード
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会開催予定場所コード(RString 介護認定審査会開催予定場所コード) {
        requireNonNull(介護認定審査会開催予定場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定場所コード"));
        entity.setShinsakaiKaisaiYoteiBashoCode(介護認定審査会開催予定場所コード);
        return this;
    }

    /**
     * 合議体番号を設定します。
     *
     * @param 合議体番号 合議体番号
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set合議体番号(int 合議体番号) {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        entity.setGogitaiNo(合議体番号);
        return this;
    }

    /**
     * 介護認定審査会予定定員を設定します。
     *
     * @param 介護認定審査会予定定員 介護認定審査会予定定員
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会予定定員(int 介護認定審査会予定定員) {
        requireNonNull(介護認定審査会予定定員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会予定定員"));
        entity.setShinsakaiYoteiTeiin(介護認定審査会予定定員);
        return this;
    }

    /**
     * 介護認定審査会最大定員を設定します。
     *
     * @param 介護認定審査会最大定員 介護認定審査会最大定員
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会最大定員(int 介護認定審査会最大定員) {
        requireNonNull(介護認定審査会最大定員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会最大定員"));
        entity.setShinsakaiSaidaiTeiin(介護認定審査会最大定員);
        return this;
    }

    /**
     * 介護認定審査会自動割当定員を設定します。
     *
     * @param 介護認定審査会自動割当定員 介護認定審査会自動割当定員
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会自動割当定員(int 介護認定審査会自動割当定員) {
        requireNonNull(介護認定審査会自動割当定員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会自動割当定員"));
        entity.setShinsakaiJidoWariateTeiin(介護認定審査会自動割当定員);
        return this;
    }

    /**
     * 介護認定審査会委員定員を設定します。
     *
     * @param 介護認定審査会委員定員 介護認定審査会委員定員
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会委員定員(int 介護認定審査会委員定員) {
        requireNonNull(介護認定審査会委員定員, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員定員"));
        entity.setShinsakaiIinTeiin(介護認定審査会委員定員);
        return this;
    }

    /**
     * 介護認定審査会資料作成年月日を設定します。
     *
     * @param 介護認定審査会資料作成年月日 介護認定審査会資料作成年月日
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会資料作成年月日(FlexibleDate 介護認定審査会資料作成年月日) {
        requireNonNull(介護認定審査会資料作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会資料作成年月日"));
        entity.setShinsakaiShiryoSakuseiYMD(介護認定審査会資料作成年月日);
        return this;
    }

    /**
     * 介護認定審査会進捗状況を設定します。
     *
     * @param 介護認定審査会進捗状況 介護認定審査会進捗状況
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会進捗状況(Code 介護認定審査会進捗状況) {
        requireNonNull(介護認定審査会進捗状況, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会進捗状況"));
        entity.setShinsakaiShinchokuJokyo(介護認定審査会進捗状況);
        return this;
    }

    /**
     * 介護認定審査会割当済み人数を設定します。
     *
     * @param 介護認定審査会割当済み人数 介護認定審査会割当済み人数
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set介護認定審査会割当済み人数(int 介護認定審査会割当済み人数) {
        requireNonNull(介護認定審査会割当済み人数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当済み人数"));
        entity.setShinsakaiWariateZumiNinzu(介護認定審査会割当済み人数);
        return this;
    }

    /**
     * 資料作成済フラグを設定します。
     *
     * @param 資料作成済フラグ 資料作成済フラグ
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder set資料作成済フラグ(boolean 資料作成済フラグ) {
        requireNonNull(資料作成済フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("資料作成済フラグ"));
        entity.setShiryoSakuseiZumiFlag(資料作成済フラグ);
        return this;
    }

    /**
     * モバイルデータ出力年月日を設定します。
     *
     * @param モバイルデータ出力年月日 モバイルデータ出力年月日
     * @return {@link ShinsakaiKaisaiYoteiJohoBuilder}
     */
    public ShinsakaiKaisaiYoteiJohoBuilder setモバイルデータ出力年月日(FlexibleDate モバイルデータ出力年月日) {
        requireNonNull(モバイルデータ出力年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("モバイルデータ出力年月日"));
        entity.setMobileDataOutputYMD(モバイルデータ出力年月日);
        return this;
    }

    /**
     * 介護認定審査会割当情報のキー情報について判定します。<br>
     * 介護認定審査会開催予定情報に関連できる介護認定審査会割当情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護認定審査会割当情報リストに介護認定審査会割当情報{@link ShinsakaiWariateJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護認定審査会割当情報 {@link ShinsakaiWariateJoho}
     * @return {@link ShinsakaiWariateJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShinsakaiKaisaiYoteiJohoBuilder setShinsakaiWariateJoho(ShinsakaiWariateJoho 介護認定審査会割当情報) {
        if (hasSameIdentifier(介護認定審査会割当情報.identifier())) {
            shinsakaiWariateJoho.add(介護認定審査会割当情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShinsakaiWariateJohoIdentifier 介護認定審査会割当情報識別子) {
        return (id.get介護認定審査会開催番号().equals(介護認定審査会割当情報識別子.get介護認定審査会開催番号()));
    }

    /**
     * 介護認定審査会割当委員情報のキー情報について判定します。<br>
     * 介護認定審査会開催予定情報に関連できる介護認定審査会割当委員情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護認定審査会割当委員情報リストに介護認定審査会割当委員情報{@link ShinsakaiWariateIinJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護認定審査会割当委員情報 {@link ShinsakaiWariateIinJoho}
     * @return ShinsakaiWariateIinJohoBuilder
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShinsakaiKaisaiYoteiJohoBuilder setShinsakaiWariateIinJoho(ShinsakaiWariateIinJoho 介護認定審査会割当委員情報) {
        if (hasSameIdentifier(介護認定審査会割当委員情報.identifier())) {
            shinsakaiWariateIinJoho.add(介護認定審査会割当委員情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShinsakaiWariateIinJohoIdentifier 介護認定審査会割当委員情報識別子) {
        return (id.get介護認定審査会開催番号().equals(介護認定審査会割当委員情報識別子.get介護認定審査会開催番号()));
    }

    /**
     * 介護認定審査会音声情報のキー情報について判定します。<br>
     * 介護認定審査会開催予定情報に関連できる介護認定審査会音声情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護認定審査会音声情報リストに介護認定審査会音声情報{@link ShinsakaiOnseiJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護認定審査会音声情報 {@link ShinsakaiOnseiJoho}
     * @return ShinsakaiOnseiJohoBuilder
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShinsakaiKaisaiYoteiJohoBuilder setShinsakaiOnseiJoho(ShinsakaiOnseiJoho 介護認定審査会音声情報) {
        if (hasSameIdentifier(介護認定審査会音声情報.identifier())) {
            shinsakaiOnseiJoho.add(介護認定審査会音声情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShinsakaiOnseiJohoIdentifier 介護認定審査会音声情報識別子) {
        return (id.get介護認定審査会開催番号().equals(介護認定審査会音声情報識別子.get介護認定審査会開催番号()));
    }

    /**
     * 介護認定審査会開催結果情報のキー情報について判定します。<br>
     * 介護認定審査会開催予定情報に関連できる介護認定審査会開催結果情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護認定審査会開催結果情報リストに介護認定審査会開催結果情報{@link ShinsakaiKaisaiKekkaJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護認定審査会開催結果情報 {@link ShinsakaiKaisaiKekkaJoho}
     * @return ShinsakaiKaisaiKekkaJohoBuilder
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShinsakaiKaisaiYoteiJohoBuilder setShinsakaiKaisaiKekkaJoho(ShinsakaiKaisaiKekkaJoho 介護認定審査会開催結果情報) {
        if (hasSameIdentifier(介護認定審査会開催結果情報.identifier())) {
            shinsakaiKaisaiKekkaJoho.add(介護認定審査会開催結果情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShinsakaiKaisaiKekkaJohoIdentifier 介護認定審査会開催結果情報識別子) {
        return (id.get介護認定審査会開催番号().equals(介護認定審査会開催結果情報識別子.get介護認定審査会開催番号()));
    }

    /**
     * {@link ShinsakaiKaisaiYoteiJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiKaisaiYoteiJoho}のインスタンス
     */
    public ShinsakaiKaisaiYoteiJoho build() {
        return new ShinsakaiKaisaiYoteiJoho(entity, id, shinsakaiWariateJoho, shinsakaiWariateIinJoho, shinsakaiOnseiJoho, shinsakaiKaisaiKekkaJoho);
    }

}
