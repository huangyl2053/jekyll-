/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZA010001;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.ShikakuFuseigoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZA010001.ShikakuFuseigoShuseiMainDiv;
import jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo.ShikakuFuseigoShuseiService;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 資格不整合修正の抽象ValidationHandleクラスです。
 *
 * @reamsid_L DBB-0630-010 chengsanyuan
 */
public class ShikakuFuseigoShuseiMainValidationHandler {

    private final ShikakuFuseigoShuseiMainDiv div;
    private final ShikakuFuseigoShuseiService service;
    private static final RString 対象項目_資格取得日 = new RString("資格取得日");
    private static final RString 対象項目_資格喪失日 = new RString("資格喪失日");
    private static final RString 対象項目_資格変更日 = new RString("資格変更日");
    private static final RString 対象項目_他市町村住所地特例適用 = new RString("他市町村住所地特例適用.適用日");
    private static final RString 対象項目_他市町村住所地特例解除 = new RString("他市町村住所地特例解除.解除日");
    private static final RString 対象項目_適用除外適用 = new RString("適用除外適用.適用日");
    private static final RString 対象項目_適用除外解除 = new RString("適用除外解除.解除日");

    /**
     * コンストラクタです。
     *
     * @param div 資格不整合修正Div
     */
    public ShikakuFuseigoShuseiMainValidationHandler(ShikakuFuseigoShuseiMainDiv div) {
        this.div = div;
        this.service = ShikakuFuseigoShuseiService.createInstance();
    }

    /**
     * 更新前の整合性チェック
     *
     * @param 台帳種別 RString
     * @param shikakuFusei 不整合修正中
     * @param 修正後の資格の情報 HihokenshaDaicho
     * @param 修正後の除外の情報 TekiyoJogaisha
     * @param 修正後の他特の情報 TashichosonJushochiTokurei
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs beforeUpdCheck(RString 台帳種別, ShikakuFuseigoBusiness shikakuFusei, HihokenshaDaicho 修正後の資格の情報,
            TekiyoJogaisha 修正後の除外の情報, TashichosonJushochiTokurei 修正後の他特の情報) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        Map<RString, DbzErrorMessages> msg = new HashMap<>();
        if (台帳種別.equals(DaichoType.被保険者.getコード())) {
            msg = service.validate被保台帳整合(shikakuFusei.get個人情報(),
                    修正後の資格の情報);
        }
        if (台帳種別.equals(DaichoType.適用除外者.getコード())) {
            msg = service.validate被保台帳整合(shikakuFusei.get個人情報(),
                    修正後の除外の情報);
        }
        if (台帳種別.equals(DaichoType.他市町村住所地特例者.getコード())) {
            msg = service.validate被保台帳整合(shikakuFusei.get個人情報(),
                    修正後の他特の情報);
        }
        if (msg.get(対象項目_資格取得日) != null) {
            validationMessages.add(new ValidationMessageControlPair(msg.get(対象項目_資格取得日), div.getTxtShikakuShutokuYmd()));
        }
        if (msg.get(対象項目_資格喪失日) != null) {
            validationMessages.add(new ValidationMessageControlPair(msg.get(対象項目_資格喪失日), div.getTxtShikakuSoshitsuYmd()));
        }
        if (msg.get(対象項目_資格変更日) != null) {
            validationMessages.add(new ValidationMessageControlPair(msg.get(対象項目_資格変更日), div.getTxtShikakuHenkoYmd()));
        }
        if (msg.get(対象項目_他市町村住所地特例適用) != null) {
            validationMessages.add(new ValidationMessageControlPair(msg.get(対象項目_他市町村住所地特例適用), div.getTxtTatokuTekiyoYmd()));
        }
        if (msg.get(対象項目_他市町村住所地特例解除) != null) {
            validationMessages.add(new ValidationMessageControlPair(msg.get(対象項目_他市町村住所地特例解除), div.getTxtTatokuKaijoYmd()));
        }
        if (msg.get(対象項目_適用除外適用) != null) {
            validationMessages.add(new ValidationMessageControlPair(msg.get(対象項目_適用除外適用), div.getTxtTekiyoJogaiTekiyoYmd()));
        }
        if (msg.get(対象項目_適用除外解除) != null) {
            validationMessages.add(new ValidationMessageControlPair(msg.get(対象項目_適用除外解除), div.getTxtTekiyoJogaiKaijoYmd()));
        }
        return validationMessages;
    }
}
