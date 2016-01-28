/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke;

import static jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.CheckForNullUtil.checkNullForAtenaKanaMeisho;
import static jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.CheckForNullUtil.checkNullForAtenaMeisho;
import static jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.CheckForNullUtil.checkNullForCode;
import static jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.CheckForNullUtil.checkNullForFlexibleDate;
import static jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.CheckForNullUtil.checkNullForRString;
import static jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.CheckForNullUtil.checkNullForShinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.CheckForNullUtil.checkNullForShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.TaishouIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会対象者割付対象者一覧エリア
 */
public class Taishouichiran {

    private final TaishouIchiranEntity entity;

    public Taishouichiran(TaishouIchiranEntity entity) {
        this.entity = new TaishouIchiranEntity();
        this.entity.set介護認定審査会審査順(entity.get介護認定審査会審査順());
        this.entity.set介護認定審査会審査順確定フラグ(entity.is介護認定審査会審査順確定フラグ());
        this.entity.set介護認定審査会優先振分区分コード(checkNullForCode(entity.get介護認定審査会優先振分区分コード()));
        this.entity.set被保険者番号(checkNullForRString(entity.get被保険者番号()));
        this.entity.set被保険者氏名(checkNullForAtenaKanaMeisho(entity.get被保険者氏名()));
        this.entity.set性別(checkNullForCode(entity.get性別()));
        this.entity.set被保険者区分コード(checkNullForRString(entity.get被保険者区分コード()));
        this.entity.set認定申請区分_申請時コード(checkNullForCode(entity.get認定申請区分_申請時コード()));
        this.entity.set認定申請年月日(checkNullForFlexibleDate(entity.get認定申請年月日()));
        this.entity.set前回認定有効期間_開始(checkNullForFlexibleDate(entity.get前回認定有効期間_開始()));
        this.entity.set前回認定有効期間_終了(checkNullForFlexibleDate(entity.get前回認定有効期間_終了()));
        this.entity.set要介護認定一次判定年月日(checkNullForFlexibleDate(entity.get要介護認定一次判定年月日()));
        this.entity.setマスキング完了年月日(checkNullForFlexibleDate(entity.getマスキング完了年月日()));
        this.entity.set市町村名称(checkNullForRString(entity.get市町村名称()));
        this.entity.set証記載保険者番号(checkNullForShoKisaiHokenshaNo(entity.get証記載保険者番号()));
        this.entity.set調査票_障害高齢者の日常生活自立度コード(checkNullForCode(entity.get調査票_障害高齢者の日常生活自立度コード()));
        this.entity.set調査票_認知症高齢者の日常生活自立度コード(checkNullForCode(entity.get調査票_認知症高齢者の日常生活自立度コード()));
        this.entity.set意見書_障害高齢者の日常生活自立度コード(checkNullForCode(entity.get意見書_障害高齢者の日常生活自立度コード()));
        this.entity.set意見書_認知症高齢者の日常生活自立度コード(checkNullForCode(entity.get意見書_認知症高齢者の日常生活自立度コード()));
        this.entity.set入所施設(checkNullForRString(entity.get入所施設()));
        this.entity.set事業者名称(checkNullForRString(entity.get事業者名称()));
        this.entity.set調査員氏名(checkNullForRString(entity.get調査員氏名()));
        this.entity.set再調査依頼回数(entity.get再調査依頼回数());
        this.entity.set医療機関名称(checkNullForRString(entity.get医療機関名称()));
        this.entity.set主治医氏名(checkNullForAtenaMeisho(entity.get主治医氏名()));
        this.entity.set申請書管理番号(checkNullForShinseishoKanriNo(entity.get申請書管理番号()));
    }

    /**
     * get介護認定審査会審査順
     *
     * @return 介護認定審査会審査順
     */
    public int get介護認定審査会審査順() {
        return entity.get介護認定審査会審査順();
    }

    /**
     * get介護認定審査会審査順
     *
     * @return 介護認定審査会審査順
     */
    public Boolean get介護認定審査会審査順確定フラグ() {
        return entity.is介護認定審査会審査順確定フラグ();
    }

    /**
     * get介護認定審査会優先振分区分コード
     *
     * @return 介護認定審査会優先振分区分コード
     */
    public Code get介護認定審査会優先振分区分コード() {
        return entity.get介護認定審査会優先振分区分コード();
    }

    /**
     * get被保険者番号
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * get被保険者氏名
     *
     * @return 被保険者氏名
     */
    public AtenaKanaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * get性別
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.get性別();
    }

    /**
     * get被保険者区分コード
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.get被保険者区分コード();
    }

    /**
     * get認定申請区分_申請時コード
     *
     * @return 認定申請区分_申請時コード
     */
    public Code get認定申請区分_申請時コード() {
        return entity.get認定申請区分_申請時コード();
    }

    /**
     * get認定申請年月日
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * get前回認定有効期間_開始
     *
     * @return 前回認定有効期間_開始
     */
    public FlexibleDate get前回認定有効期間_開始() {
        return entity.get前回認定有効期間_開始();
    }

    /**
     * get前回認定有効期間_終了
     *
     * @return 前回認定有効期間_終了
     */
    public FlexibleDate get前回認定有効期間_終了() {
        return entity.get前回認定有効期間_終了();
    }

    /**
     * get要介護認定一次判定年月日
     *
     * @return 要介護認定一次判定年月日
     */
    public FlexibleDate get要介護認定一次判定年月日() {
        return entity.get要介護認定一次判定年月日();
    }

    /**
     * getマスキング完了年月日
     *
     * @return マスキング完了年月日
     */
    public FlexibleDate getマスキング完了年月日() {
        return entity.getマスキング完了年月日();
    }

    /**
     * get市町村名称
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.get市町村名称();
    }

    /**
     * get証記載保険者番号
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * get調査票_障害高齢者の日常生活自立度コード
     *
     * @return 調査票_障害高齢者の日常生活自立度コード
     */
    public Code get調査票_障害高齢者の日常生活自立度コード() {
        return entity.get調査票_障害高齢者の日常生活自立度コード();
    }

    /**
     * get調査票_認知症高齢者の日常生活自立度コード
     *
     * @return 調査票_認知症高齢者の日常生活自立度コード
     */
    public Code get調査票_認知症高齢者の日常生活自立度コード() {
        return entity.get調査票_認知症高齢者の日常生活自立度コード();
    }

    /**
     * get意見書_障害高齢者の日常生活自立度コード
     *
     * @return 意見書_障害高齢者の日常生活自立度コード
     */
    public Code get意見書_障害高齢者の日常生活自立度コード() {
        return entity.get意見書_障害高齢者の日常生活自立度コード();
    }

    /**
     * get意見書_認知症高齢者の日常生活自立度コード
     *
     * @return 意見書_認知症高齢者の日常生活自立度コード
     */
    public Code get意見書_認知症高齢者の日常生活自立度コード() {
        return entity.get意見書_認知症高齢者の日常生活自立度コード();
    }

    /**
     * get入所施設
     *
     * @return 入所施設
     */
    public RString get入所施設() {
        return entity.get入所施設();
    }

    /**
     * get事業者名称
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.get事業者名称();
    }

    /**
     * get調査員氏名
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.get調査員氏名();
    }

    /**
     * get再調査依頼回数
     *
     * @return 再調査依頼回数
     */
    public int get再調査依頼回数() {
        return entity.get再調査依頼回数();
    }

    /**
     * get医療機関名称
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * get主治医氏名
     *
     * @return 主治医氏名
     */
    public AtenaMeisho get主治医氏名() {
        return entity.get主治医氏名();
    }

    /**
     * get申請書管理番号
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get申請書管理番号();
    }
}
