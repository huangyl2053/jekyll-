/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定進捗情報のエンティティクラスです。
 *
 * @author N8187 久保田 英男
 */
public class DbT5005NinteiShinchokuJohoEntity implements IDbAccessable {

    /**
     * 要介護認定進捗情報テーブル
     */
    @TableName
    public static final RString TABLE_NAME = new RString("T5005NinteiShinchokuJoho");
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private FlexibleDate ninteiShinseiJohoTorokuYMD;
    private boolean enkitsuchiDoiUmuKubun;
    private FlexibleDate enkitsuchiHakkoYMD;
    private int enkitsuchiHakkoKaisu;
    private RString ninteiEnkiRuyu;
    private FlexibleDate ichijihanteiChushutsuYMD;
    private FlexibleDate iraiJohoSoshinYMD;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private FlexibleDate ichijiHanteiKanryoYMD;
    private FlexibleDate ichiGoHanteiKanryoYMD;
    private FlexibleDate ninteiShinsakaiWariateKanryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private FlexibleDate centerSoshinYMD;

    /**
     * デフォルトコンストラクタです。
     */
    public DbT5005NinteiShinchokuJohoEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param ninteiShinseiJohoTorokuYMD 認定申請情報登録年月日
     * @param enkitsuchiDoiUmuKubun 認定延期通知発行に対する同意有無
     * @param enkitsuchiHakkoYMD 認定延期通知発行年月日
     * @param enkitsuchiHakkoKaisu 認定延期通知発行回数
     * @param ninteiEnkiRuyu 要介護認定延期理由
     * @param ichijihanteiChushutsuYMD 要介護認定一次判定情報抽出年月日
     * @param iraiJohoSoshinYMD 依頼情報データ送信年月日
     * @param ninteichosaIraiKanryoYMD 認定調査依頼完了年月日
     * @param ninteichosaKanryoYMD 認定調査完了年月日
     * @param ikenshoSakuseiIraiKanryoYMD 主治医意見書作成依頼完了年月日
     * @param ikenshoTorokuKanryoYMD 主治医意見書登録完了年月日
     * @param ichijiHanteiKanryoYMD 要介護認定一次判定完了年月日
     * @param ichiGoHanteiKanryoYMD 要介護認定1.5次判定完了年月日
     * @param ninteiShinsakaiWariateKanryoYMD 認定審査会割当完了年月日
     * @param ninteiShinsakaiKanryoYMD 認定審査会完了年月日
     * @param centerSoshinYMD センター送信年月日
     */
    public DbT5005NinteiShinchokuJohoEntity(
            ShinseishoKanriNo shinseishoKanriNo,
            FlexibleDate ninteiShinseiJohoTorokuYMD,
            boolean enkitsuchiDoiUmuKubun,
            FlexibleDate enkitsuchiHakkoYMD,
            int enkitsuchiHakkoKaisu,
            RString ninteiEnkiRuyu,
            FlexibleDate ichijihanteiChushutsuYMD,
            FlexibleDate iraiJohoSoshinYMD,
            FlexibleDate ninteichosaIraiKanryoYMD,
            FlexibleDate ninteichosaKanryoYMD,
            FlexibleDate ikenshoSakuseiIraiKanryoYMD,
            FlexibleDate ikenshoTorokuKanryoYMD,
            FlexibleDate ichijiHanteiKanryoYMD,
            FlexibleDate ichiGoHanteiKanryoYMD,
            FlexibleDate ninteiShinsakaiWariateKanryoYMD,
            FlexibleDate ninteiShinsakaiKanryoYMD,
            FlexibleDate centerSoshinYMD) {

        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteiShinseiJohoTorokuYMD = ninteiShinseiJohoTorokuYMD;
        this.enkitsuchiDoiUmuKubun = enkitsuchiDoiUmuKubun;
        this.enkitsuchiHakkoYMD = enkitsuchiHakkoYMD;
        this.enkitsuchiHakkoKaisu = enkitsuchiHakkoKaisu;
        this.ninteiEnkiRuyu = ninteiEnkiRuyu;
        this.ichijihanteiChushutsuYMD = ichijihanteiChushutsuYMD;
        this.iraiJohoSoshinYMD = iraiJohoSoshinYMD;
        this.ninteichosaIraiKanryoYMD = ninteichosaIraiKanryoYMD;
        this.ninteichosaKanryoYMD = ninteichosaKanryoYMD;
        this.ikenshoSakuseiIraiKanryoYMD = ikenshoSakuseiIraiKanryoYMD;
        this.ikenshoTorokuKanryoYMD = ikenshoTorokuKanryoYMD;
        this.ichijiHanteiKanryoYMD = ichijiHanteiKanryoYMD;
        this.ichiGoHanteiKanryoYMD = ichiGoHanteiKanryoYMD;
        this.ninteiShinsakaiWariateKanryoYMD = ninteiShinsakaiWariateKanryoYMD;
        this.ninteiShinsakaiKanryoYMD = ninteiShinsakaiKanryoYMD;
        this.centerSoshinYMD = centerSoshinYMD;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 認定申請情報登録年月日を返します。
     *
     * @return ninteiShinseiJohoTorokuYMD
     */
    public FlexibleDate getNinteiShinseiJohoTorokuYMD() {
        return ninteiShinseiJohoTorokuYMD;
    }

    /**
     * 認定延期通知発行に対する同意有無が有効かどうかを返します。
     *
     * @return {@code true}:有効、{@code false}:無効
     */
    public boolean isEnkitsuchiDoiUmuKubun() {
        return enkitsuchiDoiUmuKubun;
    }

    /**
     * 認定延期通知発行年月日を返します。
     *
     * @return enkitsuchiHakkoYMD
     */
    public FlexibleDate getEnkitsuchiHakkoYMD() {
        return enkitsuchiHakkoYMD;
    }

    /**
     * 認定延期通知発行回数を返します。
     *
     * @return enkitsuchiHakkoKaisu
     */
    public int getEnkitsuchiHakkoKaisu() {
        return enkitsuchiHakkoKaisu;
    }

    /**
     * 要介護認定延期理由を返します。
     *
     * @return ninteiEnkiRuyu
     */
    public RString getNinteiEnkiRuyu() {
        return ninteiEnkiRuyu;
    }

    /**
     * 要介護認定一次判定情報抽出年月日を返します。
     *
     * @return ichijihanteiChushutsuYMD
     */
    public FlexibleDate getIchijihanteiChushutsuYMD() {
        return ichijihanteiChushutsuYMD;
    }

    /**
     * 依頼情報データ送信年月日を返します。
     *
     * @return iraiJohoSoshinYMD
     */
    public FlexibleDate getIraiJohoSoshinYMD() {
        return iraiJohoSoshinYMD;
    }

    /**
     * 認定調査依頼完了年月日を返します。
     *
     * @return ninteichosaIraiKanryoYMD
     */
    public FlexibleDate getNinteichosaIraiKanryoYMD() {
        return ninteichosaIraiKanryoYMD;
    }

    /**
     * 認定調査完了年月日を返します。
     *
     * @return ninteichosaKanryoYMD
     */
    public FlexibleDate getNinteichosaKanryoYMD() {
        return ninteichosaKanryoYMD;
    }

    /**
     * 主治医意見書作成依頼完了年月日を返します。
     *
     * @return ikenshoSakuseiIraiKanryoYMD
     */
    public FlexibleDate getIkenshoSakuseiIraiKanryoYMD() {
        return ikenshoSakuseiIraiKanryoYMD;
    }

    /**
     * 主治医意見書登録完了年月日を返します。
     *
     * @return ikenshoTorokuKanryoYMD
     */
    public FlexibleDate getIkenshoTorokuKanryoYMD() {
        return ikenshoTorokuKanryoYMD;
    }

    /**
     * 要介護認定一次判定完了年月日を返します。
     *
     * @return ichijiHanteiKanryoYMD
     */
    public FlexibleDate getIchijiHanteiKanryoYMD() {
        return ichijiHanteiKanryoYMD;
    }

    /**
     * 要介護認定1.5次判定完了年月日を返します。
     *
     * @return ichiGoHanteiKanryoYMD
     */
    public FlexibleDate getIchiGoHanteiKanryoYMD() {
        return ichiGoHanteiKanryoYMD;
    }

    /**
     * 認定審査会割当完了年月日を返します。
     *
     * @return ninteiShinsakaiWariateKanryoYMD
     */
    public FlexibleDate getNinteiShinsakaiWariateKanryoYMD() {
        return ninteiShinsakaiWariateKanryoYMD;
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return ninteiShinsakaiKanryoYMD
     */
    public FlexibleDate getNinteiShinsakaiKanryoYMD() {
        return ninteiShinsakaiKanryoYMD;
    }

    /**
     * センター送信年月日を返します。
     *
     * @return centerSoshinYMD
     */
    public FlexibleDate getCenterSoshinYMD() {
        return centerSoshinYMD;
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 認定申請情報登録年月日を設定します。
     *
     * @param ninteiShinseiJohoTorokuYMD 認定申請情報登録年月日
     */
    public void setNinteiShinseiJohoTorokuYMD(FlexibleDate ninteiShinseiJohoTorokuYMD) {
        this.ninteiShinseiJohoTorokuYMD = ninteiShinseiJohoTorokuYMD;
    }

    /**
     * 認定延期通知発行に対する同意有無を設定します。
     *
     * @param enkitsuchiDoiUmuKubun 認定延期通知発行に対する同意有無
     */
    public void setEnkitsuchiDoiUmuKubun(boolean enkitsuchiDoiUmuKubun) {
        this.enkitsuchiDoiUmuKubun = enkitsuchiDoiUmuKubun;
    }

    /**
     * 認定延期通知発行年月日を設定します。
     *
     * @param enkitsuchiHakkoYMD 認定延期通知発行年月日
     */
    public void setEnkitsuchiHakkoYMD(FlexibleDate enkitsuchiHakkoYMD) {
        this.enkitsuchiHakkoYMD = enkitsuchiHakkoYMD;
    }

    /**
     * 認定延期通知発行回数を設定します。
     *
     * @param enkitsuchiHakkoKaisu 認定延期通知発行回数
     */
    public void setEnkitsuchiHakkoKaisu(int enkitsuchiHakkoKaisu) {
        this.enkitsuchiHakkoKaisu = enkitsuchiHakkoKaisu;
    }

    /**
     * 要介護認定延期理由を設定します。
     *
     * @param ninteiEnkiRuyu 要介護認定延期理由
     */
    public void setNinteiEnkiRuyu(RString ninteiEnkiRuyu) {
        this.ninteiEnkiRuyu = ninteiEnkiRuyu;
    }

    /**
     * 要介護認定一次判定情報抽出年月日を設定します。
     *
     * @param ichijihanteiChushutsuYMD 要介護認定一次判定情報抽出年月日
     */
    public void setIchijihanteiChushutsuYMD(FlexibleDate ichijihanteiChushutsuYMD) {
        this.ichijihanteiChushutsuYMD = ichijihanteiChushutsuYMD;
    }

    /**
     * 依頼情報データ送信年月日を設定します。
     *
     * @param iraiJohoSoshinYMD 依頼情報データ送信年月日
     */
    public void setIraiJohoSoshinYMD(FlexibleDate iraiJohoSoshinYMD) {
        this.iraiJohoSoshinYMD = iraiJohoSoshinYMD;
    }

    /**
     * 認定調査依頼完了年月日を設定します。
     *
     * @param ninteichosaIraiKanryoYMD 認定調査依頼完了年月日
     */
    public void setNinteichosaIraiKanryoYMD(FlexibleDate ninteichosaIraiKanryoYMD) {
        this.ninteichosaIraiKanryoYMD = ninteichosaIraiKanryoYMD;
    }

    /**
     * 認定調査完了年月日を設定します。
     *
     * @param ninteichosaKanryoYMD 認定調査完了年月日
     */
    public void setNinteichosaKanryoYMD(FlexibleDate ninteichosaKanryoYMD) {
        this.ninteichosaKanryoYMD = ninteichosaKanryoYMD;
    }

    /**
     * 主治医意見書作成依頼完了年月日を設定します。
     *
     * @param ikenshoSakuseiIraiKanryoYMD 主治医意見書作成依頼完了年月日
     */
    public void setIkenshoSakuseiIraiKanryoYMD(FlexibleDate ikenshoSakuseiIraiKanryoYMD) {
        this.ikenshoSakuseiIraiKanryoYMD = ikenshoSakuseiIraiKanryoYMD;
    }

    /**
     * 主治医意見書登録完了年月日を設定します。
     *
     * @param ikenshoTorokuKanryoYMD 主治医意見書登録完了年月日
     */
    public void setIkenshoTorokuKanryoYMD(FlexibleDate ikenshoTorokuKanryoYMD) {
        this.ikenshoTorokuKanryoYMD = ikenshoTorokuKanryoYMD;
    }

    /**
     * 要介護認定一次判定完了年月日を設定します。
     *
     * @param ichijiHanteiKanryoYMD 要介護認定一次判定完了年月日
     */
    public void setIchijiHanteiKanryoYMD(FlexibleDate ichijiHanteiKanryoYMD) {
        this.ichijiHanteiKanryoYMD = ichijiHanteiKanryoYMD;
    }

    /**
     * 要介護認定1.5次判定完了年月日を設定します。
     *
     * @param ichiGoHanteiKanryoYMD 要介護認定1.5次判定完了年月日
     */
    public void setIchiGoHanteiKanryoYMD(FlexibleDate ichiGoHanteiKanryoYMD) {
        this.ichiGoHanteiKanryoYMD = ichiGoHanteiKanryoYMD;
    }

    /**
     * 認定審査会割当完了年月日を設定します。
     *
     * @param ninteiShinsakaiWariateKanryoYMD 認定審査会割当完了年月日
     */
    public void setNinteiShinsakaiWariateKanryoYMD(FlexibleDate ninteiShinsakaiWariateKanryoYMD) {
        this.ninteiShinsakaiWariateKanryoYMD = ninteiShinsakaiWariateKanryoYMD;
    }

    /**
     * 認定審査会完了年月日を設定します。
     *
     * @param ninteiShinsakaiKanryoYMD 認定審査会完了年月日
     */
    public void setNinteiShinsakaiKanryoYMD(FlexibleDate ninteiShinsakaiKanryoYMD) {
        this.ninteiShinsakaiKanryoYMD = ninteiShinsakaiKanryoYMD;
    }

    /**
     * センター送信年月日を設定します。
     *
     * @param centerSoshinYMD センター送信年月日
     */
    public void setCenterSoshinYMD(FlexibleDate centerSoshinYMD) {
        this.centerSoshinYMD = centerSoshinYMD;
    }
}
