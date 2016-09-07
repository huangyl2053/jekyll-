/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinhoshunyuryoku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 審査会委員報酬入力ビジネスクラスです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
public class ShinsakaiIinJoho implements Serializable {

    private final ShinsakaiIinHoshuNyuryokuEntity entity;

    /**
     * コンストラクタです。<br/>
     * 審査会委員報酬入力ビジネスの新規作成時に使用します。
     *
     * @param relateEntity 審査会委員報酬入力RelateEntityクラスです。
     */
    public ShinsakaiIinJoho(ShinsakaiIinHoshuNyuryokuEntity relateEntity) {
        requireNonNull(relateEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員報酬入力RelateEntity"));
        this.entity = relateEntity;
    }

    /**
     * 介護認定審査会委員コードを返します。
     *
     * @return 介護認定審査会委員コード
     *
     */
    public RString getコード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 介護認定審査会委員氏名を返します。
     *
     * @return 介護認定審査会委員氏名
     *
     */
    public AtenaMeisho get氏名() {
        return entity.getShinsakaiIinShimei();
    }

    /**
     * 介護認定審査会委員カナを返します。
     *
     * @return 介護認定審査会委員カナ
     *
     */
    public AtenaKanaMeisho getカナ() {
        return entity.getShinsakaiIinKanaShimei();
    }

    /**
     * 介護認定審査会委員資格コードを返します。
     *
     * @return 介護認定審査会委員資格コード
     *
     */
    public Code get資格コード() {
        return entity.getShinsakaiIinShikakuCode();
    }

    /**
     * 介護認定審査会委員資格開始年月日を返します。
     *
     * @return 介護認定審査会委員資格開始年月日
     *
     */
    public FlexibleDate get開始年月日() {
        return entity.getShinsakaiIinKaishiYMD();
    }

    /**
     * 介護認定審査会委員資格終了年月日を返します。
     *
     * @return 介護認定審査会委員資格終了年月日
     *
     */
    public FlexibleDate get終了年月日() {
        return entity.getShinsakaiIinShuryoYMD();
    }

    /**
     * 廃止フラグを返します。
     *
     * @return 廃止フラグ
     *
     */
    public boolean is廃止フラグ() {
        return entity.isHaishiFlag();
    }

    /**
     * 介護認定審査会委員資格実施日を返します。
     *
     * @return 介護認定審査会委員資格実施日
     *
     */
    public FlexibleDate get実施日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 審査会委員報酬区分を返します。
     *
     * @return 審査会委員報酬区分
     *
     */
    public Code get区分() {
        return entity.getShinsakaiIinHoshuKubun();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     *
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 合議体長区分コードを返します。
     *
     * @return 合議体長区分コード
     *
     */
    public Code get合議体長区分() {
        return entity.getGogitaichoKubunCode();
    }

    /**
     * 委員出席を返します。
     *
     * @return 委員出席
     *
     */
    public boolean is出欠() {
        return entity.isShussekiFlag();
    }

    /**
     * 委員出席時間を返します。
     *
     * @return 委員出席時間
     *
     */
    public RString get出席() {
        return entity.getShussekiTime();
    }

    /**
     * 委員退席時間を返します。
     *
     * @return 委員退席時間
     *
     */
    public RString get退席() {
        return entity.getTaisekiTime();
    }

    /**
     * 介護認定審査報酬を返します。
     *
     * @return 介護認定審査報酬
     *
     */
    public int get審査報酬額() {
        return entity.getShinsakaiHoshu();
    }

    /**
     * 介護認定審査その他報酬を返します。
     *
     * @return 介護認定審査その他報酬
     *
     */
    public int getその他報酬額() {
        return entity.getShinsakaiSonotaHoshu();
    }

    /**
     * 介護認定審査会報酬税率を返します。
     *
     * @return 介護認定審査会報酬税率
     *
     */
    public int get税率() {
        return entity.getShinsakaiHoshuZeiritsu();
    }

    /**
     * 介護認定審査交通費等を返します。
     *
     * @return 介護認定審査交通費等
     *
     */
    public int get交通費等() {
        return entity.getShinsakaiKotsuhi();
    }

    /**
     * 介護認定審査控除税額を返します。
     *
     * @return 介護認定審査控除税額
     *
     */
    public int get控除税額() {
        return entity.getShinsakaiKojoZeigaku();
    }

    /**
     * 介護認定審査報酬合計を返します。
     *
     * @return 介護認定審査報酬合計
     *
     */
    public int get税引後支払額() {
        return entity.getShinsakaiHoshuGokei();
    }

    /**
     * 介護認定審査報酬支払メモを返します。
     *
     * @return 介護認定審査報酬支払メモ
     *
     */
    public RString get支払メモ() {
        return entity.getHoshuShiharaiMemo();
    }

    /**
     * 銀行振込出力フラグを返します。
     *
     * @return 銀行振込出力フラグ
     *
     */
    public boolean is振込() {
        return entity.isGinkoFurikomiShutsuryokuFlag();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     *
     */
    public int get連番() {
        return entity.getRemban();
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     *
     */
    public RString get開催結果開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 介護認定審査会委員別単価を返します。
     *
     * @return 介護認定審査会委員別単価
     *
     */
    public RString get介護認定審査会委員別単価() {
        return entity.getTanka();
    }
}
