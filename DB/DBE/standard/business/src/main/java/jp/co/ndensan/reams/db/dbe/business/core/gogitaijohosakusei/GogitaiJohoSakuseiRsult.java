/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 合議体情報作成のビジネスクラスです
 */
public class GogitaiJohoSakuseiRsult implements Serializable {

    private final GogitaiJohoSakuseiRelateEntity entity;
    private RString status;

    /**
     * 状態を取得します。
     *
     * @return 状態
     */
    public RString getStatus() {
        return status;
    }

    /**
     * 状態を設定します。
     *
     * @param status 状態
     */
    public void setStatus(RString status) {
        this.status = status;
    }

    /**
     * コンストラクタです。
     *
     * @param entity 合議体情報作成RelateEntity
     */
    public GogitaiJohoSakuseiRsult(GogitaiJohoSakuseiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.getGogitaiMei();
    }

    /**
     * 合議体有効期間開始年月日を取得します。
     *
     * @return 合議体有効期間開始年月日
     */
    public FlexibleDate get合議体有効期間開始年月日() {
        return entity.getGogitaiYukoKikanKaishiYMD();
    }

    /**
     * 合議体有効期間終了年月日を取得します。
     *
     * @return 合議体有効期間終了年月日
     */
    public FlexibleDate get合議体有効期間終了年月日() {
        return entity.getGogitaiYukoKikanShuryoYMD();
    }

    /**
     * 合議体開始予定時刻を取得します。
     *
     * @return 合議体開始予定時刻
     */
    public RString get合議体開始予定時刻() {
        return entity.getGogitaiKaishiYoteiTime();
    }

    /**
     * 合議体終了予定時刻を取得します。
     *
     * @return 合議体終了予定時刻
     */
    public RString get合議体終了予定時刻() {
        return entity.getGogitaiShuryoYoteiTime();
    }

    /**
     * 介護認定審査会予定定員を取得します。
     *
     * @return 介護認定審査会予定定員
     */
    public int get介護認定審査会予定定員() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 介護認定審査会自動割当定員を取得します。
     *
     * @return 介護認定審査会自動割当定員
     */
    public int get介護認定審査会自動割当定員() {
        return entity.getShinsakaiJidoWariateTeiin();
    }

    /**
     * 介護認定審査会委員定員を取得します。
     *
     * @return 介護認定審査会委員定員
     */
    public int get介護認定審査会委員定員() {
        return entity.getShinsakaiIinTeiin();
    }

    /**
     * 合議体精神科医存在フラグを取得します。
     *
     * @return 合議体精神科医存在フラグ
     */
    public boolean is合議体精神科医存在フラグ() {
        return entity.isGogitaiSeishinkaSonzaiFlag();
    }

    /**
     * 合議体ダミーフラグを取得します。
     *
     * @return 合議体ダミーフラグ
     */
    public boolean is合議体ダミーフラグ() {
        return entity.isGogitaiDummyFlag();
    }

    /**
     * 介護認定審査会開催場所コードを取得します。
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString get介護認定審査会開催場所コード() {
        return entity.getShinsakaiKaisaiBashoCode();
    }

    /**
     * 開催場所名称を取得します。
     *
     * @return 開催場所名称
     */
    public RString get開催場所名称() {
        return entity.getShinsakaiKaisaiBashoName();
    }

    /**
     * 合議体長区分コードを取得します。
     *
     * @return 合議体長区分コード
     */
    public Code get合議体長区分コード() {
        return entity.getGogitaichoKubunCode();
    }

    /**
     * 介護認定審査会委員コードを取得します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 審査会委員名称を取得します。
     *
     * @return 審査会委員名称
     */
    public AtenaMeisho get審査会委員名称() {
        return entity.getShinsakaiIinShimei();
    }

    /**
     * 補欠を取得します。
     *
     * @return 補欠
     */
    public boolean is補欠() {
        return entity.isSubstituteFlag();
    }

    /**
     * CSV出力用、合議体情報一覧の行データを取得します。
     *
     * @return List<RString>
     */
    public List<RString> toList() {
        List<RString> retList = new ArrayList<>();
        retList.add(new RString(String.valueOf(this.get合議体番号())).padZeroToLeft(2));
        retList.add(this.get合議体名称());
        retList.add(this.get合議体有効期間開始年月日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        retList.add(this.get合議体有効期間終了年月日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        retList.add(this.get合議体開始予定時刻());
        retList.add(this.get合議体終了予定時刻());
        retList.add(new RString(String.valueOf(this.get介護認定審査会予定定員())));
        retList.add(new RString(String.valueOf(this.get介護認定審査会自動割当定員())));
        retList.add(new RString(String.valueOf(this.get介護認定審査会委員定員())));
        retList.add(this.get介護認定審査会開催場所コード());
        retList.add(new RString(String.valueOf(this.is合議体精神科医存在フラグ())));
        retList.add(new RString(String.valueOf(this.is合議体ダミーフラグ())));
        retList.add(nullToBlank(this.get介護認定審査会委員コード()));
        retList.add(new RString(String.valueOf(this.is補欠())));
        retList.add(this.get合議体長区分コード() == null ? RString.EMPTY : this.get合議体長区分コード().value());
        return retList;
    }

    private RString nullToBlank(RString str) {
        if (str == null) {
            return RString.EMPTY;
        }
        return str;
    }
}
