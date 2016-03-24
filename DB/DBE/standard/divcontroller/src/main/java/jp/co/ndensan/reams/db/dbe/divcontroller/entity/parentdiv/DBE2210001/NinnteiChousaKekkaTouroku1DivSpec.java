/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 認定調査結果登録1バリデーションクラスです。
 */
public enum NinnteiChousaKekkaTouroku1DivSpec implements IPredicate<NinnteiChousaKekkaTouroku1Div> {

    調査実施日の非空チェック {
                /**
                 * 調査実施日の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:調査実施日が非空です、false:調査実施日が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate() != null;
                }
            },
    実施場所の非空チェック {
                /**
                 * 実施場所の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:実施場所が非空です、false:実施場所が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return !div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey().isNullOrEmpty();
                }
            },
    所属機関の非空チェック {
                /**
                 * 所属機関の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:所属機関が非空です、false:所属機関が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return !div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedKey().isNullOrEmpty();
                }
            },
    記入者の非空チェック {
                /**
                 * 記入者の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:記入者が非空です、false:記入者が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return !div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedKey().isNullOrEmpty();
                }
            },
    第1群の非空チェック {
                /**
                 * 第1群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第1群に未入力項目がない、false:第1群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return true;
//                    return !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getChkMahi().getSelectedKeys().isEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getChkKoshuku().getSelectedKeys().isEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadNeKaeri().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadOkiAgari().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadZai().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadRyoAshi().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadBuko().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadTachiAgari().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadKataAshi().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadSenshin().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadTumeKiri().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadShiryoku().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadChoryoku().getSelectedKey().isNullOrEmpty();
                }
            },
    第2群の非空チェック {
                /**
                 * 第2群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第2群に未入力項目がない、false:第2群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return true;
//                    return !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadIjyo().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadIdou().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadEnka().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadShokuji().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHainyo().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHaiben().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadKokou().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadSengan().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadSeihatsu().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadUwagi().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadZubon().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHindo().getSelectedKey().isNullOrEmpty();
                }
            },
    第3群の非空チェック {
                /**
                 * 第3群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第3群に未入力項目がない、false:第3群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return true;
//                    return !div.getCcdSangunKihonChosa().getNinchiKinou().getRadIshiDentatsu().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadNikka().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadInfo().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadDankiKioku().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadNameInfo().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadKisetsu().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadBasho().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadHaikai().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSangunKihonChosa().getNinchiKinou().getRadModoru().getSelectedKey().isNullOrEmpty();
                }
            },
    第4群の非空チェック {
                /**
                 * 第4群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第4群に未入力項目がない、false:第4群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return true;
//                    return !div.getCcdYongunKihonChosa().getKoudoShogai().getRadbtnHiryaku().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadTukuriHanashi().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadKanjyo().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadChuyaku().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadOnajiHanashi().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadBigVoice().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadTeikou().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadOchituki().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadOutLonly().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadShushu().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadKowasu().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadMonoWasure().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadHitoriWarai().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadKateKodo().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdYongunKihonChosa().getKoudoShogai().getRadMatomeNai().getSelectedKey().isNullOrEmpty();
                }
            },
    第5群の非空チェック {
                /**
                 * 第5群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第5群のに未入力項目がない、false:第5群のに未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return true;
//                    return !div.getCcdGogun().getShakaiSekatsu().getRadKusuri().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdGogun().getShakaiSekatsu().getRadKingakuKanri().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdGogun().getShakaiSekatsu().getRadIshiKetei().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdGogun().getShakaiSekatsu().getRadShudan().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdGogun().getShakaiSekatsu().getRadKaiMono().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdGogun().getShakaiSekatsu().getRadKantanChori().getSelectedKey().isNullOrEmpty();
                }
            },
    生活自立度の非空チェック {
                /**
                 * 生活自立度の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:生活自立度に未入力項目がない、false:生活自立度に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return true;
//                    return !div.getCcdSeikatsuJiritsudoKihonchosa().getJiritsudo().getRadShogaiKoreisha().getSelectedKey().isNullOrEmpty()
//                    && !div.getCcdSeikatsuJiritsudoKihonchosa().getJiritsudo().getRadNinchishaJiritsudo().getSelectedKey().isNullOrEmpty();
                }
            }

}
