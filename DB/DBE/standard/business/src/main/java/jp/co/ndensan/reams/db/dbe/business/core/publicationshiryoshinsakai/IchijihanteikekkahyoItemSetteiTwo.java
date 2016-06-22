/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.publicationshiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoItem;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiTwo {

    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");
    private static final RString 結果比較有 = new RString("★");
    private static final RString 結果比較無 = new RString("☆");
    private static final RString 結果比較_未 = new RString("未");

    /**
     * 認定調査と主治医意見書の結果比較の設定です。
     *
     * @param item 委員用一次判定結果票のEntity
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param dbT5211厚労省IF識別コード dbT5211厚労省IF識別コード
     * @param itiziHanteiEntity ItiziHanteiEntity
     * @return IchijihanteikekkahyoItem
     */
    public IchijihanteikekkahyoItem set認定調査と主治医意見書の結果比較(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査左_上肢コード = RString.EMPTY;
        RString 医意見書左_上肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査左_上肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医意見書コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書左_上肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書左_上肢コード.compareTo(認定調査左_上肢コード) > 0) {
            item.set結果比較_麻痺_左_上肢(結果比較有);
        } else if (認定調査左_上肢コード.compareTo(医意見書左_上肢コード) > 0) {
            item.set結果比較_麻痺_左_上肢(結果比較無);
        }
        RString 認定調査右_上肢コード = RString.EMPTY;
        RString 医意見書右_上肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査右_上肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医右_上肢コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書右_上肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書右_上肢コード.compareTo(認定調査右_上肢コード) > 0) {
            item.set結果比較_麻痺_右_上肢(結果比較有);
        } else if (認定調査右_上肢コード.compareTo(医意見書右_上肢コード) > 0) {
            item.set結果比較_麻痺_右_上肢(結果比較無);
        }
        RString 認定調査左_下肢コード = RString.EMPTY;
        RString 医意見書左_下肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査左_下肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医左_下肢コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書左_下肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書左_下肢コード.compareTo(認定調査左_下肢コード) > 0) {
            item.set結果比較_麻痺_左_下肢(結果比較有);
        } else if (認定調査左_下肢コード.compareTo(医意見書左_下肢コード) > 0) {
            item.set結果比較_麻痺_左_下肢(結果比較無);
        }
        set結果比較1(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較2(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較3(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較4(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較5(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較6(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較7(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        set結果比較8(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較1(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査右_下肢コード = RString.EMPTY;
        RString 医意見書右_下肢コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査右_下肢コード = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医右_下肢コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書右_下肢コード = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書右_下肢コード.compareTo(認定調査右_下肢コード) > 0) {
            item.set結果比較_麻痺_右_下肢(結果比較有);
        } else if (認定調査右_下肢コード.compareTo(医意見書右_下肢コード) > 0) {
            item.set結果比較_麻痺_右_下肢(結果比較無);
        }
        RString 認定調査その他 = RString.EMPTY;
        RString 医意見書その他 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査その他 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医その他コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書その他 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書その他.compareTo(認定調査その他) > 0) {
            item.set結果比較_麻痺_その他(結果比較有);
        } else if (認定調査その他.compareTo(医意見書その他) > 0) {
            item.set結果比較_麻痺_その他(結果比較無);
        }
        RString 認定調査拘縮_肩関節 = RString.EMPTY;
        RString 医意見書拘縮_肩関節 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査拘縮_肩関節 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医拘縮_肩関節コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書拘縮_肩関節 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書拘縮_肩関節.compareTo(認定調査拘縮_肩関節) > 0) {
            item.set結果比較_拘縮_肩関節(結果比較有);
        } else if (認定調査拘縮_肩関節.compareTo(医意見書拘縮_肩関節) > 0) {
            item.set結果比較_拘縮_肩関節(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較_食事摂取(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査食事摂取 = RString.EMPTY;
        RString 医意見書食事摂取 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査食事摂取 = ChosaAnser20.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医食事摂取コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書食事摂取 = IkenKomoku14.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku14.記載なし.getコード().equals(医意見書食事摂取) && IkenKomoku14.全面介助.getコード().equals(医意見書食事摂取)
                && !ChosaAnser20.全介助.getコード().equals(認定調査食事摂取)) {
            item.set結果比較_食事摂取(結果比較有);
        } else if (!IkenKomoku14.記載なし.getコード().equals(医意見書食事摂取)
                && IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(医意見書食事摂取)
                && !ChosaAnser20.自立.getコード().equals(認定調査食事摂取)) {
            item.set結果比較_食事摂取(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査食事摂取) && RString.isNullOrEmpty(医意見書食事摂取)) {
            item.set結果比較_食事摂取(結果比較_未);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較2(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        set結果比較_食事摂取(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        RString 認定調査意思の伝達 = RString.EMPTY;
        RString 医意見書意思の伝達 = RString.EMPTY;
        if (get意思の伝達コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査意思の伝達 = ChosaAnser14.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医意思の伝達コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書意思の伝達 = IkenKomoku06.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku06.記載なし.getコード().equals(医意見書意思の伝達) && 医意見書意思の伝達.compareTo(認定調査意思の伝達) > 0) {
            item.set結果比較_意思の伝達(結果比較有);
        } else if (!IkenKomoku06.記載なし.getコード().equals(医意見書意思の伝達) && 認定調査意思の伝達.compareTo(医意見書意思の伝達) > 0) {
            item.set結果比較_意思の伝達(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査意思の伝達) && RString.isNullOrEmpty(医意見書意思の伝達)) {
            item.set結果比較_意思の伝達(結果比較_未);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較3(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査短期記憶 = RString.EMPTY;
        RString 医意見書短期記憶 = RString.EMPTY;
        if (get短期記憶コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査短期記憶 = ChosaAnser15.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医短期記憶コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書短期記憶 = IkenKomoku04.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku04.記載なし.getコード().equals(医意見書短期記憶) && 医意見書短期記憶.compareTo(認定調査短期記憶) > 0) {
            item.set結果比較_短期記憶(結果比較有);
        } else if (!IkenKomoku04.記載なし.getコード().equals(医意見書短期記憶) && 認定調査短期記憶.compareTo(医意見書短期記憶) > 0) {
            item.set結果比較_短期記憶(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査短期記憶) && RString.isNullOrEmpty(医意見書短期記憶)) {
            item.set結果比較_短期記憶(結果比較_未);
        }
        // TODO QA回答まち
//        RString 認定調査徘徊 = RString.EMPTY;
//        RString 医意見書徘徊 = RString.EMPTY;
//        if (get徘徊コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
//                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
//            認定調査徘徊 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
//        }
//        if (get主治医徘徊コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
//                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
//            医意見書徘徊 = IkenKomoku06.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
//        }
//        if (医意見書徘徊.compareTo(認定調査徘徊) > 0) {
//            item.set結果比較_徘徊(結果比較有);
//        } else {
//            item.set結果比較_徘徊(結果比較無);
//        }
//        RString 認定調査被害的 = RString.EMPTY;
//        RString 医意見書被害的 = RString.EMPTY;
//        if (get被害的コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
//                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
//            認定調査被害的 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
//        }
//        if (get主治医被害的コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
//                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
//            医意見書被害的 = IkenKomoku06.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
//        }
//        if (医意見書被害的.compareTo(認定調査被害的) > 0) {
//            item.set結果比較_被害的(結果比較有);
//        } else {
//            item.set結果比較_被害的(結果比較無);
//        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較4(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査昼夜逆転 = RString.EMPTY;
        RString 医意見書昼夜逆転 = RString.EMPTY;
        if (get昼夜逆転コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査昼夜逆転 = ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医昼夜逆転コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書昼夜逆転 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if ((ChosaAnser16.ある.getコード().equals(認定調査昼夜逆転) || ChosaAnser16.ときどきある.getコード().equals(認定調査昼夜逆転))
                && IkenKomoku01.無.getコード().equals(医意見書昼夜逆転)) {
            item.set結果比較_昼夜逆転(結果比較無);
        } else if (ChosaAnser16.ない.getコード().equals(認定調査昼夜逆転) && IkenKomoku01.有.getコード().equals(医意見書昼夜逆転)) {
            item.set結果比較_昼夜逆転(結果比較有);
        }
        RString 認定調査介護に抵抗 = RString.EMPTY;
        RString 医意見書介護に抵抗 = RString.EMPTY;
        if (get介護に抵抗コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査介護に抵抗 = ChosaAnser16.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医介護に抵抗コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書介護に抵抗 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (IkenKomoku01.有.getコード().equals(医意見書介護に抵抗) && ChosaAnser16.ない.getコード().equals(認定調査介護に抵抗)) {
            item.set結果比較_介護に抵抗(結果比較有);
        } else if ((ChosaAnser16.ある.getコード().equals(認定調査介護に抵抗) || ChosaAnser16.ときどきある.getコード().equals(認定調査介護に抵抗))
                && IkenKomoku01.無.getコード().equals(医意見書介護に抵抗)) {
            item.set結果比較_介護に抵抗(結果比較無);
        }
        set結果比較_日常の意思決定(item, 厚労省IF識別コード, dbT5211厚労省IF識別コード, itiziHanteiEntity);
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較_日常の意思決定(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査日常の意思決定 = RString.EMPTY;
        RString 医意見書日常の意思決定 = RString.EMPTY;
        if (get日常の意思決定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査日常の意思決定 = ChosaAnser17.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医日常の意思決定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書日常の意思決定 = IkenKomoku05.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (!IkenKomoku05.記載なし.getコード().equals(医意見書日常の意思決定) && 医意見書日常の意思決定.compareTo(認定調査日常の意思決定) > 0) {
            item.set結果比較_日常の意思決定(結果比較有);
        } else if (!IkenKomoku05.記載なし.getコード().equals(医意見書日常の意思決定)
                && 認定調査日常の意思決定.compareTo(医意見書日常の意思決定) > 0) {
            item.set結果比較_日常の意思決定(結果比較無);
        } else if (!RString.isNullOrEmpty(認定調査日常の意思決定) && RString.isNullOrEmpty(医意見書日常の意思決定)) {
            item.set結果比較_日常の意思決定(結果比較_未);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較5(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査点滴の管理 = RString.EMPTY;
        RString 医意見書点滴の管理 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査点滴の管理 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医点滴の管理コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書点滴の管理 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書点滴の管理.compareTo(認定調査点滴の管理) > 0) {
            item.set結果比較_点滴の管理(結果比較有);
        } else {
            item.set結果比較_点滴の管理(結果比較無);
        }
        RString 認定調査中心静脈栄養 = RString.EMPTY;
        RString 医意見書中心静脈栄養 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査中心静脈栄養 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医中心静脈栄養コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書中心静脈栄養 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書中心静脈栄養.compareTo(認定調査中心静脈栄養) > 0) {
            item.set結果比較_中心静脈栄養(結果比較有);
        } else {
            item.set結果比較_中心静脈栄養(結果比較無);
        }
        RString 認定調査透析 = RString.EMPTY;
        RString 医意見書透析 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査透析 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医透析コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書透析 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書透析.compareTo(認定調査透析) > 0) {
            item.set結果比較_透析(結果比較有);
        } else {
            item.set結果比較_透析(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較6(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査ストーマの処置 = RString.EMPTY;
        RString 医意見書ストーマの処置 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査ストーマの処置 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医ストーマの処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書ストーマの処置 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書ストーマの処置.compareTo(認定調査ストーマの処置) > 0) {
            item.set結果比較_ストーマの処置(結果比較有);
        } else {
            item.set結果比較_ストーマの処置(結果比較無);
        }
        RString 認定調査酸素療法 = RString.EMPTY;
        RString 医意見書酸素療法 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査酸素療法 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医酸素療法コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書酸素療法 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書酸素療法.compareTo(認定調査酸素療法) > 0) {
            item.set結果比較_酸素療法(結果比較有);
        } else {
            item.set結果比較_酸素療法(結果比較無);
        }
        RString 認定調査レスピレーター = RString.EMPTY;
        RString 医意見書レスピレーター = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査レスピレーター = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医レスピレーターコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書レスピレーター = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書レスピレーター.compareTo(認定調査レスピレーター) > 0) {
            item.set結果比較_レスピレーター(結果比較有);
        } else if (認定調査レスピレーター.compareTo(医意見書レスピレーター) > 0) {
            item.set結果比較_レスピレーター(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較7(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査気管切開の処置 = RString.EMPTY;
        RString 医意見書気管切開の処置 = RString.EMPTY;
        if (get気管切開の処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査気管切開の処置 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医気管切開の処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書気管切開の処置 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書気管切開の処置.compareTo(認定調査気管切開の処置) > 0) {
            item.set結果比較_気管切開の処置(結果比較有);
        } else if (認定調査気管切開の処置.compareTo(医意見書気管切開の処置) > 0) {
            item.set結果比較_気管切開の処置(結果比較無);
        }
        RString 認定調査疼痛の看護 = RString.EMPTY;
        RString 医意見書疼痛の看護 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査疼痛の看護 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医疼痛の看護コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書疼痛の看護 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書疼痛の看護.compareTo(認定調査疼痛の看護) > 0) {
            item.set結果比較_疼痛の看護(結果比較有);
        } else if (認定調査疼痛の看護.compareTo(医意見書疼痛の看護) > 0) {
            item.set結果比較_疼痛の看護(結果比較無);
        }
        RString 認定調査経管栄養 = RString.EMPTY;
        RString 医意見書経管栄養 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getコード(厚労省IF識別コード, itiziHanteiEntity.getDbt5211_remban()))
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査経管栄養 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医経管栄養コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書経管栄養 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書経管栄養.compareTo(認定調査経管栄養) > 0) {
            item.set結果比較_経管栄養(結果比較有);
        } else if (認定調査経管栄養.compareTo(医意見書経管栄養) > 0) {
            item.set結果比較_経管栄養(結果比較無);
        }
        return item;
    }

    private IchijihanteikekkahyoItem set結果比較8(IchijihanteikekkahyoItem item,
            RString 厚労省IF識別コード, RString dbT5211厚労省IF識別コード, ItiziHanteiEntity itiziHanteiEntity) {
        RString 認定調査モニター測定 = RString.EMPTY;
        RString 医意見書モニター測定 = RString.EMPTY;
        if (getモニター測定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査モニター測定 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医モニター測定コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書モニター測定 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書モニター測定.compareTo(認定調査モニター測定) > 0) {
            item.set結果比較_モニター測定(結果比較有);
        } else if (認定調査モニター測定.compareTo(医意見書モニター測定) > 0) {
            item.set結果比較_モニター測定(結果比較無);
        }
        RString 認定調査じょくそうの処置 = RString.EMPTY;
        RString 医意見書じょくそうの処置 = RString.EMPTY;
        if (getじょくそうの処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査じょくそうの処置 = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医じょくそうの処置コード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書じょくそうの処置 = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書じょくそうの処置.compareTo(認定調査じょくそうの処置) > 0) {
            item.set結果比較_じょくそうの処置(結果比較有);
        } else if (認定調査じょくそうの処置.compareTo(医意見書じょくそうの処置) > 0) {
            item.set結果比較_じょくそうの処置(結果比較無);
        }

        RString 認定調査カテーテル = RString.EMPTY;
        RString 医意見書カテーテル = RString.EMPTY;
        if (getカテーテルコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5211_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5211_koroshoIfShikibetsuCode().value())) {
            認定調査カテーテル = ChosaAnser01.toValue(itiziHanteiEntity.getDbt5211_researchItem()).getコード();
        }
        if (get主治医カテーテルコード(厚労省IF識別コード) == itiziHanteiEntity.getDbt5304_remban()
                && dbT5211厚労省IF識別コード.equals(itiziHanteiEntity.getDbt5304_koroshoIfShikibetsuCode().value())) {
            医意見書カテーテル = IkenKomoku01.toValue(itiziHanteiEntity.getDbt5304_ikenItem()).getコード();
        }
        if (医意見書カテーテル.compareTo(認定調査カテーテル) > 0) {
            item.set結果比較_カテーテル(結果比較有);
        } else if (認定調査カテーテル.compareTo(医意見書カテーテル) > 0) {
            item.set結果比較_カテーテル(結果比較無);
        }
        return item;
    }

    private int get主治医カテーテルコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.カテーテル.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.カテーテル.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.カテーテル.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.カテーテル.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.カテーテル.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医じょくそうの処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.じょくそうの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.じょくそうの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.じょくそうの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.じょくそうの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.じょくそうの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医モニター測定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.モニター測定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.モニター測定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.モニター測定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.モニター測定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.モニター測定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医経管栄養コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.経管栄養.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.経管栄養.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.経管栄養.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.経管栄養.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.経管栄養.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医疼痛の看護コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.疼痛の看護.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.疼痛の看護.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.疼痛の看護.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.疼痛の看護.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.疼痛の看護.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医気管切開の処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.気管切開の処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.気管切開の処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.気管切開の処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.気管切開の処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.気管切開の処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医レスピレーターコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.レスピレーター.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.レスピレーター.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.レスピレーター.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.レスピレーター.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.レスピレーター.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医酸素療法コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.酸素療法.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.酸素療法.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.酸素療法.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.酸素療法.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.酸素療法.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医ストーマの処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.ストーマの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.ストーマの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.ストーマの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.ストーマの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.ストーマの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医透析コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.透析.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.透析.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.透析.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.透析.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.透析.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医中心静脈栄養コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.中心静脈栄養.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.中心静脈栄養.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.中心静脈栄養.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.中心静脈栄養.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.中心静脈栄養.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医点滴の管理コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.点滴の管理.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.点滴の管理.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.点滴の管理.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.点滴の管理.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.点滴の管理.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医日常の意思決定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.認知能力.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.認知能力.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.認知能力.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.認知能力.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.認知能力.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医介護に抵抗コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.介護への抵抗.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.介護への抵抗.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.介護への抵抗.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.介護への抵抗.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.介護への抵抗.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医昼夜逆転コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.昼夜逆転.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.昼夜逆転.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.昼夜逆転.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.昼夜逆転.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.昼夜逆転.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    // TODO QA回答まち
//    private int get主治医被害的コード(RString 厚労省IF識別コード) {
//        if (A_99.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping99A.被害的.getコード().toString());
//        } else if (A_02.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping02A.被害的.getコード().toString());
//        } else if (A_06.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping06A.被害的.getコード().toString());
//        } else if (A_09.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping09A.被害的.getコード().toString());
//        } else if (B_09.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping09B.被害的.getコード().toString());
//        }
//        return Integer.MAX_VALUE;
//    }
//
//    private int get主治医徘徊コード(RString 厚労省IF識別コード) {
//        if (A_99.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping99A.徘徊_問題行動.getコード().toString());
//        } else if (A_02.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping02A.徘徊_可能性が高い病態.getコード().toString());
//        } else if (A_06.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping06A.徘徊_可能性が高い病態.getコード().toString());
//        } else if (A_09.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping09A.徘徊_認知症の周辺症状.getコード().toString());
//        } else if (B_09.equals(厚労省IF識別コード)) {
//            return Integer.valueOf(IkenshoKomokuMapping09B.徘徊_可能性が高い病態.getコード().toString());
//        }
//        return Integer.MAX_VALUE;
//    }
    private int get主治医短期記憶コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.短期記憶.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.短期記憶.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.短期記憶.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.短期記憶.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.短期記憶.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医意思の伝達コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.伝達能力.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.伝達能力.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.伝達能力.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.伝達能力.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.伝達能力.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医食事摂取コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.食事行為.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.食事行為.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.食事行為.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医拘縮_肩関節コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping99A.関節の拘縮.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping02A.関節の拘縮.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.関節の拘縮.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.関節の拘縮.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.関節の拘縮.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医その他コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_その他.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_その他.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_その他.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医右_下肢コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_右下肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_右下肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_右下肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医左_下肢コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_左下肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_左下肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_左下肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医右_上肢コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_右上肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_右上肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_右上肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get主治医意見書コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping06A.麻痺_左上肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09A.麻痺_左上肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(IkenshoKomokuMapping09B.麻痺_左上肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get昼夜逆転コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.昼夜逆転.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.昼夜逆転.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.昼夜逆転.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.昼夜逆転.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.昼夜逆転.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get短期記憶コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.短期記憶.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.短期記憶.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.短期記憶.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.短期記憶.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.短期記憶.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get意思の伝達コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.意思の伝達.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.意思の伝達.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.意思の伝達.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.意思の伝達.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.意思の伝達.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get介護に抵抗コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.介護に抵抗.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.介護に抵抗.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.介護に抵抗.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.介護に抵抗.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.介護に抵抗.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get日常の意思決定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.日常の意思決定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.日常の意思決定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.日常の意思決定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.日常の意思決定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int get気管切開の処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.気管切開の処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.気管切開の処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.気管切開の処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.気管切開の処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.気管切開の処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getモニター測定コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.モニター測定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.モニター測定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.モニター測定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.モニター測定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.モニター測定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getじょくそうの処置コード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.じょくそうの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.じょくそうの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.じょくそうの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.じょくそうの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.じょくそうの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private int getカテーテルコード(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.カテーテル.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.カテーテル.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.カテーテル.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.カテーテル.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.カテーテル.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    private RString getコード(RString 厚労省IF識別コード, int コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping99A(new RString(コード));
        } else if (A_02.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping02A(new RString(コード));
        } else if (A_06.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping06A(new RString(コード));
        } else if (A_09.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping09A(new RString(コード));
        } else if (B_09.equals(厚労省IF識別コード)) {
            return getNinteichosaKomokuMapping09B(new RString(コード));
        }
        return RString.EMPTY;
    }

    private RString getNinteichosaKomokuMapping99A(RString コード) {
        try {
            return NinteichosaKomokuMapping99A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping02A(RString コード) {
        try {
            return NinteichosaKomokuMapping02A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping06A(RString コード) {
        try {
            return NinteichosaKomokuMapping06A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping09A(RString コード) {
        try {
            return NinteichosaKomokuMapping09A.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }

    private RString getNinteichosaKomokuMapping09B(RString コード) {
        try {
            return NinteichosaKomokuMapping09B.toValue(コード).getコード();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
    }
}
